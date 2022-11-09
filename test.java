
public class test {

	// Driver code
	public static void main(String[] args) throws Exception
	{
		// Request array
		String arr[] = { "176", "79", "34", "60", "92", "11", "41", "114" };
		int head = 50;

		System.out.println("Initial position of head: "
						+ head);

		cScan.CSCAN(arr, head);
		System.out.println(cScan.getSequnce());
	}
}
//176,79,34,60,92,11,41,114