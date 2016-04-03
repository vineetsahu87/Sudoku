package com.sudohu.exceptions;

/**
 * Exception class for when no solution exists for the sudoku puzzle.
 * It extends the exception class.
 * 
 * @author Vineet K Sahu
 *
 */
public class NoSolutionFoundException extends Exception {

    private static final long serialVersionUID = 1039636692550048522L;

   /**
    * Constructs a new exception with {@code null} as its detail message.
    * The cause is not initialized, and may subsequently be initialized by a
    * call to {@link #initCause}.
    */
    public NoSolutionFoundException(){
        super();
    }

   /**
    * Constructs a new exception with the specified detail message.  The
    * cause is not initialized, and may subsequently be initialized by
    * a call to {@link #initCause}.
    *
    * @param   message   the detail message. The detail message is saved for
    *          later retrieval by the {@link #getMessage()} method.
    */
    public NoSolutionFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */ 
    public NoSolutionFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */ 
    public NoSolutionFoundException(Throwable cause) {
        super(cause);
    }

   /**
    * Constructs a new exception with the specified detail message,
    * cause, suppression enabled or disabled, and writable stack
    * trace enabled or disabled.
    *
    * @param  message the detail message.
    * @param cause the cause.  (A {@code null} value is permitted,
    * and indicates that the cause is nonexistent or unknown.)
    * @param enableSuppression whether or not suppression is enabled
    *                          or disabled
    * @param writableStackTrace whether or not the stack trace should
    *                           be writable
    */  
    protected NoSolutionFoundException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
