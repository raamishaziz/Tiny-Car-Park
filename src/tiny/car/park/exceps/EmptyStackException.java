package tiny.car.park.exceps;

public class EmptyStackException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String e)
    {
        super(e);
    }
}