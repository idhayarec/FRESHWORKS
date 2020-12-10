import java.util.*;
import org.json.simple.JSONObject;
import com.datastore.main.DataStore;

public class datastore {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DataStore myDataStore = new DataStore("C:\\Users\\YOGESH\\Documents\\DataStore");
			System.out.println("***** CREATE *****\n");
			JSONObject jsonObject = new JSONObject();
			System.out.println("Enter Student Firstname:\n");
			String firstname=sc.next();
			System.out.println("Enter Student Lastname:\n");
			String lastname=sc.next();
			System.out.println("Enter Student Address:\n");
			String address=sc.next();
			jsonObject.put("firstName", firstname);
			jsonObject.put("lastName", lastname);
			jsonObject.put("address", address);
			
			// Create Operation
			// DataStore myDataStore = new DataStore();
		
			
			System.out.println(myDataStore.create("1", jsonObject, 10));// success
			//System.out.println(myDataStore.create("1", jsonObject));// failure
			//System.out.println(myDataStore.create("1", jsonObject, 10));// failure
			System.out.println(myDataStore.create("2", jsonObject));// success
			System.out.println(myDataStore.create(
					"helloDataStoreThisIsKeyNameValidation", new JSONObject()));// failure
			try {
				// wait for 10 seconds
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("====================AFTER WAIT===============");
			jsonObject.put("age", "21");
			System.out.println(myDataStore.create("1", jsonObject, 10));// success
			System.out.println(myDataStore.create("1", jsonObject));// failure
			System.out.println(myDataStore.create("1", jsonObject, 10));// failure
			System.out.println(myDataStore.create("2", jsonObject));// failure
	
		// Read Operation
			
			System.out.println("***** READ *****");
			
			System.out.println(myDataStore.read("1"));// success
			System.out.println(myDataStore.read("2"));// success
			System.out.println(myDataStore.read("3"));// failure
			try {
				// wait for 10 seconds
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("====================AFTER WAIT===============");
			System.out.println(myDataStore.read("1"));// failure
			System.out.println(myDataStore.read("2"));// success

			System.out.println("***** DELETE *****");
			System.out.println(myDataStore.delete("1"));// failure
			System.out.println(myDataStore.delete("2"));// success
			System.out.println(myDataStore.delete("2"));// failure
			System.out.println(myDataStore.delete("3"));// failure
			System.out.println(myDataStore.delete("ISTHISKEYVALIDATINGSUCCESSFULLYYESORNO"));// failure
			
		
	}
}
