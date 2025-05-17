package junit.gradle;

// Gradle dependency implementation
import com.google.common.collect.ImmutableList;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println(listOf("a", "b"));

	}
	

	public static ImmutableList<String> listOf(String... items) {
	     return ImmutableList.copyOf(items);
	 }

}
