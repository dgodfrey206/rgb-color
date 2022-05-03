/* Those are some test I used to test my own code. All those test presuppose that you passed all the artemis tests successfully
 *	and that you used ExceptionUtil.unsupportedOperation() in case of illegal inputs. This test should not crash in any case, so if
 * 	does you should definitly find out why.
 *	You can tell if a test has failed by the color of the console output and the message at the end. To use these tests	you need
 * 	to create a new package inside the pgdp.color package called test and copy this file inside.
 *	(IntelliJ: right click the pgdp.color "folder" > New > Package)
 * 	After that just run the main method.
 *
 * 	Author: Felix Hohenadel
 * */


public class Main {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) {
		boolean allTestPassed = true;
		int failedTests = 0;


		System.out.println("Tests started");

		//1 test RgbColor Class
		System.out.println("1 test RgbColor Class");
		//1.1: try negativ values for colors
		System.out.println("1.1: try negativ values for colors");
		try {
			RgbColor test = new RgbColor(5, -1, 7, 5);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbColor test = new RgbColor(5, 6, -7, 4);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbColor test = new RgbColor(5, 6, 7, -5);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		//1.2 test bitdepth boundaries
		System.out.println("1.2 test bitdepth boundaries");
		for (int i = -5; i < 35; i++) {
			try {
				RgbColor test = new RgbColor(i, 0, 0, 0);
				if (i < 1 || i > 31) {
					System.out.println(ANSI_RED + "Test failed. Bitdepth: " + i + " is not allowed" + ANSI_RESET);
					allTestPassed = false;
					failedTests++;
				}
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
		}

		//1.3 test if color values match bitdepth boundaries
		System.out.println("1.3 test if color values match bitdepth boundaries");
		for (int i = 1; i < 31; i++) {
			try {
				RgbColor test = new RgbColor(i, IntMath.powerOfTwo(i), 0, 0);
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
			try {
				RgbColor test = new RgbColor(i, 0, IntMath.powerOfTwo(i), 0);
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
			try {
				RgbColor test = new RgbColor(i, 0, 0, IntMath.powerOfTwo(i));
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
		}

		//2 test RgbaColor Class
		System.out.println("2 test RgbaColor Class");
		//2.1: try negative values for colors
		System.out.println("2.1: try negative values for colors");
		try {
			RgbaColor test = new RgbaColor(5, -1, 7, 5, 1);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbaColor test = new RgbaColor(5, 6, -1, 4, 1);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbaColor test = new RgbaColor(5, 6, 5, -1, 1);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		//2.2 test bitdepth boundaries
		System.out.println("2.2 test bitdepth boundaries");
		for (int i = -5; i < 35; i++) {
			try {
				RgbaColor test = new RgbaColor(i, 0, 0, 0, 1);
				if (i < 1 || i > 31) {
					System.out.println(ANSI_RED + "Test failed. Bitdepth: " + i + " is not allowed" + ANSI_RESET);
					allTestPassed = false;
					failedTests++;
				}
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
		}

		//2.3 test if color values match bitdepth boundaries
		System.out.println("2.3 test if color values match bitdepth boundaries");
		for (int i = 1; i < 31; i++) {
			try {
				RgbaColor test = new RgbaColor(i, IntMath.powerOfTwo(i), 0, 0, 1);
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
			try {
				RgbaColor test = new RgbaColor(i, 0, IntMath.powerOfTwo(i), 0, 1);
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
			try {
				RgbaColor test = new RgbaColor(i, 0, 0, IntMath.powerOfTwo(i), 1);
				System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
		}

		//2.4 test alpha boundaries
		System.out.println("2.4 test alpha boundaries");
		for (int i = 1; i < 31; i++) {
			try {
				RgbaColor test = new RgbaColor(i, 0, 0, 0, IntMath.powerOfTwo(i));
				System.out.println(ANSI_RED + "Test failed. Alpha value out of boundary" + ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			} catch (UnsupportedOperationException e) {
				System.out.println("Test passed. Expected error: " + e);
			}
		}

		//3 test RgbaColor8Bit Class
		System.out.println("3 test RgbColor8Bit Class");
		//3.1: try negative values for colors
		System.out.println("3.1: try negative values for colors");
		try {
			RgbColor8Bit test = new RgbColor8Bit(-1, 7, 5);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbColor8Bit test = new RgbColor8Bit(6, -1, 4);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		try {
			RgbColor8Bit test = new RgbColor8Bit(6, 5, -1);
			System.out.println(ANSI_RED + "Test failed. Negative values for colors are not allowed" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		//3.2 test if color values match bitdepth boundaries
		System.out.println("3.2 test if color values match bitdepth boundaries");
		try {
			RgbColor8Bit test = new RgbColor8Bit(IntMath.powerOfTwo(8), 0, 0);
			System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}
		try {
			RgbColor8Bit test = new RgbColor8Bit(0, IntMath.powerOfTwo(8), 0);
			System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}
		try {
			RgbColor8Bit test = new RgbColor8Bit(0, 0, IntMath.powerOfTwo(8));
			System.out.println(ANSI_RED + "Test failed. Color value out of boundary" + ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Test passed. Expected error: " + e);
		}

		//4 test conversion to 8Bit
		System.out.println("4 test conversion to 8Bit");
		//4.1 test conversion to 8Bit on normal Rgb.Color
		System.out.println("4.1 test conversion to 8Bit on normal Rgb.Color");
		for(int i=1;i<31;i++){
			RgbColor test = new RgbColor(i, IntMath.powerOfTwo(i)-1,IntMath.powerOfTwo(i)-1,IntMath.powerOfTwo(i)-1);
			if (test.toRgbColor8Bit().getRed()==255){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + i+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getRed()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
			if (test.toRgbColor8Bit().getGreen() == 255){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + i+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getGreen()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
			if (test.toRgbColor8Bit().getBlue() == 255){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + i+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getBlue()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
		}

		RgbColor test = new RgbColor(31, Integer.MAX_VALUE-1,Integer.MAX_VALUE-1,Integer.MAX_VALUE-1);
		if (test.toRgbColor8Bit().getRed()==255){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 31+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test.toRgbColor8Bit().getGreen() == 255){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 31+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test.toRgbColor8Bit().getBlue() == 255){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 31+ " ; Expected: 255 but was: "+test.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}

		//4 test conversion to 8Bit
		System.out.println("4 test conversion to 8Bit");
		//4.1 test conversion to 8Bit on normal Rgb.Color
		System.out.println("4.1 test conversion to 8Bit on normal Rgb.Color");
		for(int i=1;i<31;i++){
			RgbColor test2 = new RgbColor(i, 0,0,0);
			if (test2.toRgbColor8Bit().getRed()==0){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + i+ " ; Expected: 0 but was: "+test2.toRgbColor8Bit().getRed()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
			if (test2.toRgbColor8Bit().getGreen() == 0){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + i+ " ; Expected: 0 but was: "+test2.toRgbColor8Bit().getGreen()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
			if (test2.toRgbColor8Bit().getBlue() == 0){
				System.out.println("Tests passed. Conversion successful");
			}else{
				System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + i+ " ; Expected: 0 but was: "+test2.toRgbColor8Bit().getBlue()+ ANSI_RESET);
				allTestPassed = false;
				failedTests++;
			}
		}

		RgbColor test3 = new RgbColor(31, 0,0,0);
		if (test3.toRgbColor8Bit().getRed()==0){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 31+ " ; Expected: 0 but was: "+test3.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test3.toRgbColor8Bit().getGreen() ==0){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 31+ " ; Expected: 0 but was: "+test3.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test3.toRgbColor8Bit().getBlue() == 0){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 31+ " ; Expected: 0 but was: "+test3.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}

		//4.2 test random conversion examples on RgbColor
		System.out.println("4.2 test random conversion examples on RgbColor");
		RgbColor test1 = new RgbColor(12, 45,350,1223);
		if (test1.toRgbColor8Bit().getRed()==3){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 12 + " ; Expected: 3 but was: "+test1.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test1.toRgbColor8Bit().getGreen() == 22){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 12 + " ; Expected: 22 but was: "+test1.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test1.toRgbColor8Bit().getBlue() == 76){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 12 + " ; Expected: 76 but was: "+test1.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}


		RgbColor test4 = new RgbColor(8, 45,125,240);
		if (test4.toRgbColor8Bit().getRed()==45){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 8 + " ; Expected: 45 but was: "+test4.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test4.toRgbColor8Bit().getGreen() == 125){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 8 + " ; Expected: 125 but was: "+test4.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test4.toRgbColor8Bit().getBlue() == 240){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 8 + " ; Expected: 240 but was: "+test4.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}

		RgbColor test5 = new RgbColor(9, 1,2,3);
		if (test5.toRgbColor8Bit().getRed()==1){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 9 + " ; Expected: 1 but was: "+test5.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test5.toRgbColor8Bit().getGreen() == 1){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 9 + " ; Expected: 1 but was: "+test5.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test5.toRgbColor8Bit().getBlue() == 2){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 9 + " ; Expected: 2 but was: "+test5.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}

		RgbColor test6 = new RgbColor(7, 64,32,24);
		if (test6.toRgbColor8Bit().getRed()==129){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red at bitdepth: " + 7 + " ; Expected: 129 but was: "+test6.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test6.toRgbColor8Bit().getGreen() == 64){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green bitdepth: " + 7 + " ; Expected: 64 but was: "+test6.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test6.toRgbColor8Bit().getBlue() == 48){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue at bitdepth: " + 7 + " ; Expected: 48 but was: "+test6.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}

		//4.3 test conversion on RgbaColor
		System.out.println("4.3 test random conversion examples on RgbColor");
		RgbaColor test7 = new RgbaColor(12, 45,350,1223,4095);
		if (test7.toRgbColor8Bit().getRed()==3){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for red with full alpha at bitdepth: " + 12 + " ; Expected: 3 but was: "+test7.toRgbColor8Bit().getRed()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test7.toRgbColor8Bit().getGreen() == 22){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for green with full alpha bitdepth: " + 12 + " ; Expected: 22 but was: "+test7.toRgbColor8Bit().getGreen()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}
		if (test7.toRgbColor8Bit().getBlue() == 76){
			System.out.println("Tests passed. Conversion successful");
		}else{
			System.out.println(ANSI_RED + "Test failed. Conversion for blue with full alpha at bitdepth: " + 12 + " ; Expected: 76 but was: "+test7.toRgbColor8Bit().getBlue()+ ANSI_RESET);
			allTestPassed = false;
			failedTests++;
		}


		RgbaColor test8 = new RgbaColor(12, 45,350,1223,4094);
		try {
			RgbColor8Bit t = test8.toRgbColor8Bit();
			System.out.println(ANSI_RED + "Test failed. You cant convert RgbaColors to 8Bit if the alpha value isn't at its maximum value. bitdepth: " + 12 + " ; Alpha at 4094");
			allTestPassed = false;
			failedTests++;
		} catch (UnsupportedOperationException e) {
			System.out.println("Tests passed. transparency can't be converted to 8Bit");
		}

		if (allTestPassed) {
			System.out.println(ANSI_GREEN + "All tests passed" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + failedTests + " tests failed" + ANSI_RESET);
		}
	}
}