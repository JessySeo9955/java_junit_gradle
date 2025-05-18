package junit.gradle.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.junit.jupiter.api.Test;

public class ExceptionText {

	@Test // method 1 : Exception Check
	void throwExceptionTest() {
		assertThrows(Exception.class, () -> {
			final Path fileSystemFile = Paths.get("/tmp/existent-file.txt");

			// incorrect usage of Paths.get
			final Path wrongFile = Paths.get("http://example.com/wrong-file");

			final long fileSize = Files.size(fileSystemFile);
			final long networkFileSize = Files.size(wrongFile);

		});
	}

	@Test // method 1 : Exception Check
	void throwNoSuchFileExceptionTest() {
		assertThrows(NoSuchFileException.class, () -> {
			Files.size(Paths.get("/tmp/non-existent-file.txt"));
		});
	}

	@Test // method 2 : Explicitly expecting exceptions
	void throwExplicitNoSuchFileExceptionTest() {
		try {
			Files.size(Paths.get("/tmp/non-existent-file.txt"));
		} catch (IOException e) {
			// test passed
		}

	}
	
	@Test
	public void serviceResponseTime() {
		assertTimeout(Duration.ofMillis(1000), () -> {
            // Code under test
            Thread.sleep(500); // This will pass (under 1000 ms)
        });
	}

}
