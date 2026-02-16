import java.util.*;
import java.io.File;
import java.lang.String;

public class CodinGame {

  // split arguments
  // echo Hello Word
  public static void hello(String... args) {
    System.out.println(String.join("\n", args));
  }


  public static boolean isFoo(String param) {
    return "foo".equals(param);
  }

  // array contains occurrence
  public static boolean contains(final int[] arr, final int key) {
    return Arrays.stream(arr).anyMatch(i -> i == key);
  }

  public static int getPositionAt(int n) {
    switch (n % 6) {
    case 0:
      return 0;
    case 1:
      return 1;
    case 2:
      return -1;
    case 3:
      return -4;
    case 4:
      return -5;
    case 5:
      return -3;
    }
    return 0;
  }
  
  // find largest
  public static int findLargestNum(int[] numbers) {
    return Arrays.stream(numbers).max().getAsInt();
  }

  // find smallest	
  public static int findSmallestNum(int[] numbers) {
    return Arrays.stream(numbers).min().getAsInt();
  }

  // concat string foobar
  class StringUtils {
    String concat(String[] strings) {
      StringBuilder sb = new StringBuilder();
      for (String s : strings) {
        sb.append(s);
      }
      String result = sb.toString();
      return result;
    }
  }
  

  static boolean a(int i, int j) {
    if (i == 1 || j == 1 || (i + j == 1) || (j + 1 == 1)) {
      return true;
    } else {
      return false;
    }
  }

  // nombre de paires possibles
  static int count(int n) {
    return ((n * n) - (n * 1)) / 2;
  }


  // point de jointure
  public static computeJoinPoint(int s1, int s2) {
    int a, b = 0;
    if (s1 < s2) {
      a = s1;
      b = s2;
    } else {
      a = s2;
      b = s1;
    }
    int sum1 = a + sumOfDigits(a);
    int sum2 = b + sumOfDigits(b);
    List<Integer> list = new ArrayList<Integer>();
    while (sum1 != sum2) {
      sum1 = sum1 + sumDigit(sum1);
      sum2 = sum2 + sumDigit(sum2);
      list.add(sum2);
      for (Integer i : list) { 
        if (sum1 == i) return i;
      }
    }
    return 0;
  }

  public static Integer sumOfDigits(int num) {
    int sum = 0;

    while (num > 0) {
      sum = sum + num % 10;
      num = num / 10;
    }

    sum = (sum < 10) ? sum : sumOfDigits(sum);

    return sum;
  }
  
  // closest to Zero
  static int closestToZero(int[] ints) {
    if (ints == null || ints.length == 0) {
      return 0;
    }

    int T;
    int min = ints[0]; 
    Arrays.sort(ints);        
    // find the element nearest to zero
    for (int i = 0; i < ints.length; i++) {
      T = ints[i];
      if (Math.abs(T) < Math.abs(min) || (T == -min && T > 0)) {
        min = T;
      } 
    }
    return min;
  }

  // sum range
  static int sumRange(int[] ints) {
    int sum = 0;
    for (int i = 1; i < ints.length; i++) {
        int n = ints[i];
        if (n == 10 || n == 100) sum += n;
    }
    return sum;
  }
  
  // buffet
  public static int computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
    // Write your code here
    // To debug: System.err.println("Debug messages...");

    int dayGains = 0;
    List<Integer> currentAttendancy = new ArrayList<Integer>();
    List<Integer> currentQueue = new ArrayList<Integer>();
    List<Integer> alreadyAte = new ArrayList<Integer>();

    for (int i = 0; i < guestMovements.length; i++) // On parcourt les mouvements des touristes
    {

      if (!currentAttendancy.isEmpty() && currentAttendancy.contains(guestMovements[i])) // Si le touriste était dans la salle
      {
        if (!currentQueue.isEmpty()) // Si la queue n'est pas vide
        {
          if (!alreadyAte.contains(currentQueue.get(0))) // Si le 1er touriste de la file n'a pas mangé auparavant
          {
            dayGains += payingGuests[currentQueue.get(0)]; // il paye
            alreadyAte.add(currentQueue.get(0)); // On l'ajoute dans la liste des déjà mangeurs
          }

          currentAttendancy.add(currentQueue.get(0)); // Dans tous les cas, il est en salle
          currentQueue.remove(currentQueue.get(0));

        }
        int ind = currentAttendancy.indexOf(guestMovements[i]);

        currentAttendancy.remove(ind);
      } else if (currentQueue.contains(guestMovements[i])) //Si le touriste était dans la queue
      {
        int ind = currentQueue.indexOf(guestMovements[i]);
        currentQueue.remove(ind); // Il s'en va
      } else // On est dans le cas d'une arrivée
      {
        if (currentAttendancy.size() < nbSeats) // la salle n'est pas pleine, le touriste va s'assoire
        {
          if (!alreadyAte.contains(guestMovements[i])) // Si le touriste n'est jamais venu auparavant
          {
            dayGains += payingGuests[guestMovements[i]]; // il paye
            alreadyAte.add(guestMovements[i]); // On l'ajoute dans la liste des déjà mangeurs
          }

          currentAttendancy.add(guestMovements[i]); // Dans tous les cas, il est en salle
        } else {
          currentQueue.add(guestMovements[i]); // Le touriste est dans la file d'attente
        }
      }

    }

    return dayGains;
  }
  
  // Asci Art
  private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G'
        , 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'
        , 'X', 'Y', 'Z'
    };

    /**
     * @return the char that is represented by s
     */
    static char scanChar(String s) {
        if (s == null) {
            return '?';
        }
        for (int i = 0 ; i < ALPHABET.length ; i++) {
            if(s.equals(AsciiArt.printChar(ALPHABET[i]))) {
                return ALPHABET[i];
            }
        }
        return '?';
  }
  
  // locate universe-formula file
  public String locateUniverseFormula() {
    String path = "/tmp/documents/";
    String name = "universe-formula";

    File file = find(path, name);
    return file.getAbsolutePath();
  }

  private File find(String path, String name) {
    File file = new File(path);
    if (name.equalsIgnoreCase(file.getName())) {
      return file;
    }

    if (file.isDirectory()) {
      for (String aChild : file.list()) {
        File found = find(path + File.separator + aChild, name);
        if (found != null)
          return found;
      }
    }
    return file;
  }

  void print(Reader reader) throws IOException {
		try {
	      int code = -1;
		    while ((reader.read() != -1)) {
          System.out.print((char) code);
		    }  
	   } catch (IOException e) {
	        e.printStackTrace();
	   } finally { 
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }
	}
}