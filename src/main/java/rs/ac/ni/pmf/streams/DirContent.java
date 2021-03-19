package rs.ac.ni.pmf.streams;

import java.io.IOException;
import java.nio.file.*;

public class DirContent
{
	public static void main(String[] args) throws IOException
	{
//		final Path tempDir = Paths.get("tempDir");
//
//		try (DirectoryStream<Path> files = Files.newDirectoryStream(tempDir, new DirectoryStream.Filter<Path>()
//		{
//			@Override
//			public boolean accept(Path entry) throws IOException
//			{
//				return entry.getFileName().toString().startsWith("temp_");
//			}
//		}))
//		{
//			for (Path file : files)
//			{
//				System.out.println(file);
//			}
//		}

		final Path root = Paths.get(".");

//		try (DirectoryStream<Path> files = Files.newDirectoryStream(root))
//		{
//			for (Path file : files)
//			{
//				if (Files.isDirectory(file))
//				{
//					// Rekurentno obradimo file
//				}
//				else
//				{
//					System.out.println(file);
//				}
//			}
//		}

		Files.walkFileTree(root, new MyFileVisitor());
	}
}
