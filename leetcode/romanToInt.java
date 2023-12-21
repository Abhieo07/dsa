public class Main
{
  public static int values (char c)
  {
    switch (c)
      {
      case 'I':
	return 1;
	case 'V':return 5;
	case 'X':return 10;
	case 'L':return 50;
	case 'C':return 100;
	case 'D':return 500;
	case 'M':return 1000;
      }
    return 0;
  }

  public static int integerVal (String s)
  {
    if (s.length () == 1)
      {
	return values (s.charAt (0));
      }
    else if (s.length () == 2)
      {
	int diff = values (s.charAt (1)) - values (s.charAt (0));
	return (diff == 4 || diff == 9 || diff == 40 || diff == 90
		|| diff == 400
		|| diff ==
		900) ? diff : values (s.charAt (1)) + values (s.charAt (0));
      }
    else
      {

	int i = 0;
	int j = i + 1;
	int integer = 0;
	while (i != j && i < s.length ())
	  {
	    if (j < s.length ())
	      {
		int diff = values (s.charAt (j)) - values (s.charAt (i));
		if (diff == 4 || diff == 9 || diff == 40 || diff == 90
		    || diff == 400 || diff == 900)
		  {
		    integer += diff;
		    i = j + 1;
		    j += 2;
		  }
		else
		  {
		    integer += values (s.charAt (i));
		    i++;
		    j++;
		  }
	      }
	    else
	      {
		integer += values (s.charAt (i));
		i++;
		j++;

	      }
	  }
	return integer;
      }
  }

  public static void main (String[]args)
  {
    String s = "LVIII";
    System.out.println (integerVal (s));
  }
}
