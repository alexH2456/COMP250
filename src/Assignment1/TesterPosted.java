package Assignment1;

import java.math.BigInteger;

public class TesterPosted {

	public static void main(String[] args) throws Exception {

		// You can test the correctness of your NaturalNumber implementation
		// by using Java's BigInteger class.

		// Here is an example.

		int base = 8;
		String s1 = "7212453415123434535343435312133453421001104045340";
		String s2 = "3";

		for (int i = 0; i < 20; i++) {

			switch(i) {
			case 0:
				base = 5;
				s1 = "2";
				s2 = "1";
				break;
			case 1:
				base = 8;
				s1 = "42345614234561000343453440000343453440";
				s2 = "22320000423456100034345344000042";
				break;
			case 2:
				base = 9;
				s1 = "888";
				s2 = "8";
				break;
			case 3:
				base = 3;
				s1 = "221020";
				s2 = "22000";
				break;
			case 4:
				base = 5;
				s1 = "1234321";
				s2 = "201";
				break;
			case 5:
				base = 9;
				s1 = "12300020004323442312312115464234504500043";
				s2 = "12543434244054320474788282201540";
				break;
			case 6:
				base = 7;
				s1 = "12364040420";
				s2 = "10445412";
				break;
			case 7:
				base = 2;
				s1 = "10101000101001";
				s2 = "10001010101111";
				break;
			case 8:
				base = 6;
				s1 = "11212353550";
				s2 = "11212353550";
				break;
			case 9:
				base = 10;
				s1 = "10101000100102";
				s2 = "100234578377";
				break;
			case 10:
				base = 2;
				s1 = "1000000000000000000000000000000000000000001";
				s2 = "101";
				break;
			case 11:
				base = 4;
				s1 = "222222222";
				s2 = "22222";
				break;
			case 12:
				base = 6;
				s1 = "12355055005";
				s2 = "4000044204";
				break;
			case 13:
				base = 8;
				s1 = "7212453415123434535343435312133453421001104045340";
				s2 = "2";
				break;
			case 14:
				base = 10;
				s1 = "10";
				s2 = "10";
				break;
			case 15:
				base = 3;
				s1 = "202000110210";
				s2 = "220";
				break;
			case 16:
				base = 5;
				s1 = "444444444444444";
				s2 = "404040101010";
				break;
			case 17:
				base = 7;
				s1 = "1024165301101450011110151200404045024240";
				s2 = "1024165301101450011110151200404045024240";
				break;
			case 18:
				base = 2;
				s1 = "100000000000000000000000000000000001";
				s2 = "101";
				break;
			case 19:
				base = 10;
				s1 = "49599595643534543";
				s2 = "100";
				break;
			}

			BigInteger big1 = new BigInteger(s1, base);
			BigInteger big2 = new BigInteger(s2, base);

			NaturalNumber n1 = new NaturalNumber(s1, base);
			NaturalNumber n2 = new NaturalNumber(s2, base);

			System.out.println("n1 is    " + n1);
			System.out.println("n2 is    " + n2);
			System.out.println();

			// The BigInteger class uses an 'add' method for addition, but NaturalNumber
			// uses 'plus' instead, to avoid confusion with the LinkedList's 'add' method
			// which inserts an element.

			System.out.println("sum: big1+big2 =        (" + big1.add(big2).toString(base) + ")_" + base);
			// System.out.println(big1.add(big2).toString(base) + ")_" + base );
			System.out.println("sum: n1+n2     =        " + n1.plus(n2));
			// System.out.println(n1.plus(n2));
			System.out.println();


			// The BigInteger class uses a 'subtract' method for addition, but NaturalNumber
			// uses 'minus' instead.  This name was chosen because it was a better match
			// for 'plus'.

			System.out.println("diff: big1-big2 =       (" + big1.subtract(big2).toString(base) + ")_" + base);
			// System.out.println(big1.subtract(big2).toString(base) + ")_" + base );  // BigInteger
			System.out.println("diff: n1-n2     =       " + n1.minus(n2));
			// System.out.println(n1.minus(n2));                                       // NaturalNumber
			System.out.println();


			// The BigInteger class uses a 'multiply' method for addition. NaturalNumber
			// uses 'times' instead.

			System.out.println("multiply: big1*big2  =  (" + big1.multiply(big2).toString(base) + ")_" + base);
			// System.out.println(big1.multiply(big2).toString(base) + ")_" + base);     // BigInteger
			System.out.println("multiply: n1*n2      =  " + n1.times(n2));
			// System.out.println(n1.times(n2));                                         // NaturalNumber
			System.out.println();

			// System.out.println("slow multiply: n1*n2 =  " + n1.slowTimes(n2));           // NaturalNumber
			// System.out.println(n1.slowTimes(n2));
			// System.out.println();

			System.out.println("divide: big1/big2  =     (" + big1.divide(big2).toString(base) + ")_" + base);
			// System.out.println(big1.divide(big2).toString(base)  + ")_" + base);      // BigInteger
			System.out.println("divide: n1/n2      =     " + n1.divide(n2));
			// System.out.println(n1.divide(n2));                                        // NaturalNumber
			System.out.println();

			// System.out.println("slow divide: n1/n2 =     " + n1.slowDivide(n2));           // NaturalNumber
			// System.out.println(n1.slowDivide(n2));
			// System.out.println();

			System.out.println("==========================================================");

			/*   mod

            System.out.print("mod = ");
            System.out.println(big1.subtract(big1.divide(big2).multiply(big2)));
            System.out.println(big1.mod(big2));

			 */
		}
	}
}


