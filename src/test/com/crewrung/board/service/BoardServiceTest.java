package test.com.crewrung.board.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import com.crewrung.board.vo.BoardVO;
import com.crewrung.board.vo.BoardDetailVO;
import com.crewrung.board.service.InsertBoardService;
import com.crewrung.board.service.GetAllBoardsService;
import com.crewrung.board.service.GetBoardDetailService;
import com.crewrung.board.service.UpdateBoardService;
import com.crewrung.board.service.IncrementViewService;
import com.crewrung.board.service.DeleteBoardService;

public class BoardServiceTest {

    private InsertBoardService insertBoardService;
    private GetAllBoardsService getAllBoardsService;
    private GetBoardDetailService getBoardDetailService;
    private UpdateBoardService updateBoardService;
    private IncrementViewService incrementViewService;
    private DeleteBoardService deleteBoardService;

    @Before
    public void setUp() {
        insertBoardService      = new InsertBoardService();
        getAllBoardsService     = new GetAllBoardsService();
        getBoardDetailService   = new GetBoardDetailService();
        updateBoardService      = new UpdateBoardService();
        incrementViewService    = new IncrementViewService();
        deleteBoardService      = new DeleteBoardService();
    }

    @Test
    public void testInsertBoard() throws Exception {
        String writer = "hyunmin84";
        String title  = "테스트 제목";
        String content= "테스트 내용";

        // 1) 게시글 삽입
        insertBoardService.execute(writer, title, content);

        // 2) 전체 목록 조회
        List<BoardVO> boards = getAllBoardsService.execute();

        // 3) for-loop로 삽입된 게시글 찾기
        boolean found = false;
        for (BoardVO b : boards) {
            if (title.equals(b.getTitle()) && writer.equals(b.getWriterId())) {
                found = true;
                break;
            }
        }

        // 4) 검증
        assertTrue("삽입된 게시글이 목록에 포함되어야 한다.", found);
    }

    @Test
    public void testGetBoardDetail() throws Exception {
        String writer = "hyunmin84";
        String title  = "상세 제목";
        String content= "상세 내용";

        // 1) 게시글 삽입
        insertBoardService.execute(writer, title, content);

        // 2) 다시 목록에서 방금 삽입한 글의 번호 찾기
        List<BoardVO> boards = getAllBoardsService.execute();
        long boardNumber = -1;
        for (BoardVO b : boards) {
            if (title.equals(b.getTitle())) {
                boardNumber = b.getBoardNumber();
                break;
            }
        }
        if (boardNumber == -1) {
            fail("조회할 게시글을 찾을 수 없습니다.");
        }

        // 3) 상세 조회
        BoardDetailVO detail = getBoardDetailService.execute(boardNumber);

        // 4) 검증
        assertNotNull("게시글 상세 정보는 null이 아니어야 한다.", detail);
        assertEquals("상세 제목", detail.getTitle());
    }

    @Test
    public void testUpdateBoard() throws Exception {
        String writer    = "hyunmin84";
        String origTitle = "원본 제목";
        String origContent = "원본 내용";

        // 1) 원본 글 삽입
        insertBoardService.execute(writer, origTitle, origContent);

        // 2) 번호 찾기
        List<BoardVO> boards = getAllBoardsService.execute();
        long boardNumber = -1;
        for (BoardVO b : boards) {
            if (origTitle.equals(b.getTitle())) {
                boardNumber = b.getBoardNumber();
                break;
            }
        }
        if (boardNumber == -1) {
            fail("수정할 게시글을 찾을 수 없습니다.");
        }

        // 3) 수정 실행
        String newTitle   = "수정된 제목";
        String newContent = "수정된 내용";
        updateBoardService.execute(boardNumber, writer, newTitle, newContent);

        // 4) 상세 조회 후 검증
        BoardDetailVO detail = getBoardDetailService.execute(boardNumber);
        assertEquals("수정된 제목", detail.getTitle());
        assertEquals("수정된 내용", detail.getContent());
    }

    @Test
    public void testIncrementView() throws Exception {
        // 1) 글 삽입
        insertBoardService.execute("hyunmin84", "조회수 제목", "조회수 내용");

        // 2) 번호 찾기
        List<BoardVO> boards = getAllBoardsService.execute();
        long boardNumber = -1;
        for (BoardVO b : boards) {
            if ("조회수 제목".equals(b.getTitle())) {
                boardNumber = b.getBoardNumber();
                break;
            }
        }
        if (boardNumber == -1) {
            fail("테스트할 게시글을 찾을 수 없습니다.");
        }

        // 3) 비교 전 조회수
        BoardDetailVO before = getBoardDetailService.execute(boardNumber);
        int beforeCount = before.getViewCount(); // getViewCount()가 Integer라면 auto-unboxing

        // 4) 조회수 증가
        incrementViewService.execute((int) boardNumber);

        // 5) 다시 조회
        BoardDetailVO after = getBoardDetailService.execute(boardNumber);
        int afterCount = after.getViewCount();   // auto-unboxing(Integer → int)

        // 6) 검증
        assertEquals("조회수가 1만큼 증가해야 한다.", beforeCount + 1, afterCount);
    }


    @Test
    public void testDeleteBoard() throws Exception {
        String writer = "hyunmin84";
        String title  = "삭제 제목";
        String content= "삭제 내용";

        // 1) 글 삽입
        insertBoardService.execute(writer, title, content);

        // 2) 번호 찾기
        List<BoardVO> boards = getAllBoardsService.execute();
        long boardNumber = -1;
        for (BoardVO b : boards) {
            if (title.equals(b.getTitle())) {
                boardNumber = b.getBoardNumber();
                break;
            }
        }
        if (boardNumber == -1) {
            fail("등록된 게시글을 찾을 수 없습니다.");
        }

        // 3) 삭제 실행
        deleteBoardService.execute(boardNumber, writer);

        // 4) 삭제 후에도 목록 조회하여 남아있는지 확인
        List<BoardVO> afterDelete = getAllBoardsService.execute();
        boolean stillExists = false;
        for (BoardVO b : afterDelete) {
            if (b.getBoardNumber() == boardNumber) {
                stillExists = true;
                break;
            }
        }
        assertFalse("삭제된 게시글이 목록에 남아있으면 안 됩니다.", stillExists);
    }

    @Test
    public void testGetAllBoards() throws Exception {
        List<BoardVO> boards = getAllBoardsService.execute();
        assertNotNull("게시글 목록은 null이 아니어야 한다.", boards);
    }
}
