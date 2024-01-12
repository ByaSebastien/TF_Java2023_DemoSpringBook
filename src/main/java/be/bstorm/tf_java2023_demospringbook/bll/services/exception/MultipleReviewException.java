package be.bstorm.tf_java2023_demospringbook.bll.services.exception;

public class MultipleReviewException extends RuntimeException {

    public MultipleReviewException() {
        super("There cannot be multiple reviews of the same book by the same user");
    }
}
