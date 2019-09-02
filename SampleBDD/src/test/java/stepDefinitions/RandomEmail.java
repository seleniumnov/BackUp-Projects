package stepDefinitions;

import java.sql.Timestamp;

public class RandomEmail {

	public static void main(String[] args) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp.getTime());		
	}

}
