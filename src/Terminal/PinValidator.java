package Terminal;

// Класс для валидации пин кода

public class PinValidator
{
    private boolean overflow = false;

    private boolean valid = false;

    private int countSuccess = 0;

    private int countFailure = 0;

    public boolean isOverflow()
    {
        if(!overflow)
        {
            return false;
        }
        else
        {
            countFailure = 0;
            overflow = false;
            return true;
        }
    }

    public boolean isValid()
    {
        return valid;
    }

    public void validation(final String key, Character sign)
    {
        System.out.println("xx" + countFailure);
        if(!Character.isDigit(sign))
        {
            throw new IllegalArgumentException("The character is not a number, please enter a number");
        }
        if(!sign.equals(key.charAt(countSuccess)))
        {
            countSuccess = 0;
            ++countFailure;
            if(countFailure == 3)
                overflow = true;
            if(!overflow)
                throw new IllegalArgumentException("wrong number");
        }
        else
            {
                ++countSuccess;
                if(countSuccess == key.length())
                {
                    valid = true;
                }
            }
    }
}