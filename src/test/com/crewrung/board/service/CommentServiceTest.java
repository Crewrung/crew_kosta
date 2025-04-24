package test.com.crewrung.board.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import com.crewrung.board.service.DeleteCommentService;
import com.crewrung.board.service.GetAllCommentsService;
import com.crewrung.board.service.InsertCommentService;
import com.crewrung.board.vo.BoardCommentListVO;

public class CommentServiceTest {

    private InsertCommentService insertCommentService;
    private DeleteCommentService deleteCommentService;
    private GetAllCommentsService getAllCommentsService;

    @Before
    public void setUp() {
        insertCommentService    = new InsertCommentService();
        deleteCommentService    = new DeleteCommentService();
        getAllCommentsService   = new GetAllCommentsService();
    }

    @Test
    public void testInsertComment() throws Exception {
        String commenter = "seulbin59";
        String content   = "테스트 댓글";

        // 1) 댓글 삽입
        insertCommentService.execute(81, commenter, content);

        // 2) 전체 댓글 조회
        List<BoardCommentListVO> comments = getAllCommentsService.execute();

        // 3) for-loop로 삽입된 댓글이 있는지 검사
        boolean found = false;
        for (BoardCommentListVO c : comments) {
            if (content.equals(c.getComment())
             && commenter.equals(c.getCommenter())) {
                found = true;
                break;
            }
        }

        // 4) 검증
        assertTrue("삽입된 댓글이 목록에 포함되어야 한다.", found);
    }

    @Test
    public void testDeleteComment() throws Exception {
        String commenter = "seulbin59";
        String content   = "삭제 테스트 댓글";

        // 1) 댓글 삽입
        insertCommentService.execute(30, commenter, content);

        // 2) 삽입된 댓글 번호 찾기
        List<BoardCommentListVO> afterInsert = getAllCommentsService.execute();
        long commentNumber = -1;
        for (BoardCommentListVO c : afterInsert) {
            if (content.equals(c.getComment())
             && commenter.equals(c.getCommenter())) {
                commentNumber = c.getBoardCommentNumber();
                break;
            }
        }
        if (commentNumber == -1) {
            fail("삭제할 댓글을 찾을 수 없습니다.");
        }

        // 3) 댓글 삭제
        deleteCommentService.execute(commentNumber, commenter);

        // 4) 삭제 후 다시 조회하여 남아있는지 확인
        List<BoardCommentListVO> afterDelete = getAllCommentsService.execute();
        boolean stillExists = false;
        for (BoardCommentListVO c : afterDelete) {
            if (c.getBoardCommentNumber() == commentNumber) {
                stillExists = true;
                break;
            }
        }

        // 5) 검증
        assertFalse("삭제된 댓글이 목록에 남아있으면 안 됩니다.", stillExists);
    }

    @Test
    public void testGetAllComments() throws Exception {
        // 조회만 하고 null이 아닌 리스트가 반환되는지 확인
        List<BoardCommentListVO> comments = getAllCommentsService.execute();
        assertNotNull("댓글 목록은 null이 아니어야 한다.", comments);
    }
}
