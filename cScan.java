import java.util.*;

public class cScan {
	// Java program to demonstrate
	// C-SCAN Disk Scheduling algorithm
	private static int size = 8;
	private static int disk_size = 200;
	private static int seek_count;
	private static String sequnce=" ";
	public static String getSequnce() {
		return sequnce;
	}

	public int getSeek_count() {
		return seek_count;
	}
	
	public static void CSCAN(String arr[], int head)
	{
		seek_count=0;
		int distance, cur_track;
		
		Vector<Integer> left = new Vector<Integer>();
		Vector<Integer> right = new Vector<Integer>();
		Vector<Integer> seek_sequence = new Vector<Integer>();

		// Appending end values which has
		// to be visited before reversing
		// the direction
		left.add(0);
		right.add(getDisk_size() - 1);

		// Tracks on the left of the
		// head will be serviced when
		// once the head comes back
		// to the beggining (left end).
		for (int i = 0; i < size; i++) {
			if (Integer.parseInt(arr[i]) < head)
				left.add(Integer.parseInt(arr[i]));
			if (Integer.parseInt(arr[i]) > head)
				right.add(Integer.parseInt(arr[i]));
		}

		// Sorting left and right vectors
		Collections.sort(left);
		Collections.sort(right);

		// First service the requests
		// on the right side of the
		// head.
		for (int i = 0; i < right.size(); i++) {
			cur_track = right.get(i);

			// Appending current track to seek sequence
			seek_sequence.add(cur_track);

			// Calculate absolute distance
			distance = Math.abs(cur_track - head);

			// Increase the total count
			seek_count += distance;

			// Accessed track is now new head
			head = cur_track;
		}

		// Once reached the right end
		// jump to the beggining.
		head = 0;

		// adding seek count for head returning from 199 to
		// 0
		seek_count += (getDisk_size() - 1);

		// Now service the requests again
		// which are left.
		for (int i = 0; i < left.size(); i++) {
			cur_track = left.get(i);

			// Appending current track to
			// seek sequence
			seek_sequence.add(cur_track);

			// Calculate absolute distance
			distance = Math.abs(cur_track - head);

			// Increase the total count
			seek_count += distance;

			// Accessed track is now the new head
			head = cur_track;
		}
		
		for (int i = 0; i < seek_sequence.size(); i++) {
			sequnce+=Integer.toString(seek_sequence.get(i));
			sequnce+=" , ";
		}
	}
	
	public static int getDisk_size() {
		return disk_size;
	}
	public static void setDisk_size(int disk_size) {
		cScan.disk_size = disk_size;
	}
	public static int getSize() {
		return size;
	}
	public static void setSize(int size) {
		cScan.size = size;
	}
}
