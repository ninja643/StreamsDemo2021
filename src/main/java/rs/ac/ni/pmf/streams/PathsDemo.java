package rs.ac.ni.pmf.streams;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsDemo
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//		String homeDir = System.getProperty("user.home");
		//		Path absolutePath = Paths.get(homeDir, "temp");
		//
		//		System.out.println(absolutePath);
		//
		//		for (final File root : File.listRoots())
		//		{
		//			System.out.println(root);
		//		}

		Path path = Paths.get("temp", "data", "demo", "demo_data.tmp");
		//		Path path2 = Paths.get("temp\\test", "data", "demo2");

		//		System.out.println(path);
		//		final Path absolutePath = path.toAbsolutePath();
		//		System.out.printf("Absolute path: %s%n", absolutePath);
		//		System.out.printf("File name: %s%n", path.getFileName());
		//		//		System.out.printf("File name: %s%n", path2.getFileName());
		//
		//		//		System.out.println(path.getName(0));
		//		System.out.println("Root: " + absolutePath.getRoot());
		//		System.out.println("Names in path: ");
		//		for (int i = 0; i < absolutePath.getNameCount(); ++i)
		//		{
		//			System.out.println(absolutePath.getName(i));
		//		}
		//
		//		//		System.out.println("Path2: " + path2);
		//		//		System.out.println(path2.getName(0));
		//
		//		System.out.println(path.subpath(1, 3));

		//		Path path2 = Paths.get("demo", "test", "..", "test2", "data", "..", "data2");
		//		System.out.println(path2.normalize());

		Path absolute1 = Paths.get("src", "main", "java").toAbsolutePath();
		Path absolute2 = Paths.get("target", "java").toAbsolutePath();

		System.out.println(absolute1);
		System.out.println(absolute2);

		System.out.println(absolute1.relativize(absolute2));
		System.out.println(absolute2.relativize(absolute1));

		//		Path absolute3 = Paths.get("C:\\test\\data");

		//		System.out.println(absolute1.relativize(absolute3));

		Path path2 = Paths.get("demo", "test", "..", "test2", "data", "..", "data2");
		Path path3 = Paths.get("demo");

		if (path2.startsWith(path3))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Wrong");
		}

	}
}
