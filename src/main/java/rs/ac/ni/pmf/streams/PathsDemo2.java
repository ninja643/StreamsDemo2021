package rs.ac.ni.pmf.streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class PathsDemo2
{
	public static void main(String[] args) //throws IOException
	{
		Path path = Paths.get("letters.txt");
		Path path2 = Paths.get("test", "..", "letters.txt");

		//		System.out.println(path.toRealPath());
		//		System.out.println(path2.toRealPath());
		//
		//		if(Files.exists(path))
		//		{
		//			System.out.format("File %s found!%n", path);
		//		}
		//
		//		if(Files.notExists(path2))
		//		{
		//			System.out.format("File %s does not exist!%n", path);
		//		}
		//
		//		System.out.println(Files.isRegularFile(path));
		//		System.out.println(Files.isRegularFile(path2));
		//
		//		try
		//		{
		//			System.out.println("Same files: " + Files.isSameFile(path, path2));
		//		}
		//		catch (IOException ioException)
		//		{
		//			ioException.printStackTrace();
		//		}
		//
		//		System.out.println(Files.isReadable(path));
		//		System.out.println(Files.isWritable(path));
		//		System.out.println(Files.isExecutable(path));

		//		try
		//		{
		//			System.out.println("Copying the file...");
		//			Path copy = Files.copy(path, Paths.get("letters-copy.txt"), StandardCopyOption.REPLACE_EXISTING);
		//			System.out.println(copy);
		//
		//			System.out.println("Deleting the file...");
		//			Files.delete(copy);
		//		}
		//		catch (IOException ioException)
		//		{
		//			ioException.printStackTrace();
		//		}
		//		try
		//		{
		//			Files.delete(Paths.get("letters-bytes.txt"));
		//		}
		//		catch (IOException ioException)
		//		{
		//			ioException.printStackTrace();
		//		}
		final Path tempDir = Paths.get("tempDir");

		if (Files.notExists(tempDir))
		{
			try
			{
				Files.createDirectory(tempDir);
			}
			catch (IOException ioException)
			{
				ioException.printStackTrace();
			}
		}
		else
		{
			System.out.format("Dir '%s' already exists%n", tempDir);
		}

		Path tempPath;

		try
		{
			tempPath = Files.createTempFile(tempDir, "temp_to_delete_", ".tmp");
			System.out.println(tempPath);
			tempPath.toFile().deleteOnExit();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
			return;
		}

		try (BufferedWriter out = Files.newBufferedWriter(tempPath, StandardCharsets.UTF_8))
		{
			out.write("This is the content of a temporary file");
			out.newLine();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}

		try
		{
			final List<String> lines = Files.readAllLines(tempPath, StandardCharsets.UTF_8);
			System.out.println("Lines read: " + lines.size());
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
}
