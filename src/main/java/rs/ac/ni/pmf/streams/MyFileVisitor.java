package rs.ac.ni.pmf.streams;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path>
{
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
	{
		System.out.format("Failed to visit file %s, reason: %s", file, exc.getMessage());

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
	{
		if (attrs.isSymbolicLink())
		{
			System.out.format("Symbolic link: %s%n", file);
		}
		else if (attrs.isRegularFile())
		{
			System.out.format("Regular file: %s%n", file);
		}
		else
		{
			System.out.format("Other: %s%n", file);
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
	{
		if (exc != null)
		{
			System.out.println("ERROR: " + exc.getMessage());
		}
		else
		{
			System.out.printf("Finished directory %s%n", dir);
		}

		return FileVisitResult.CONTINUE;
	}
}
