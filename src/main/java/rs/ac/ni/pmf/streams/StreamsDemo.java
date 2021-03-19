package rs.ac.ni.pmf.streams;

import java.io.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamsDemo
{
	private static final int MAX_BYTES = 100;

	public static void main(String[] args)
	{
		try
		{
			copyBytes("letters.txt", "letters-bytes.txt");
			copyChars("letters.txt", "letters-chars.txt");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void copyChars(final String inFileName, final String outFileName) throws IOException
	{
		try (final FileReader in = new FileReader(inFileName); final FileWriter out = new FileWriter(outFileName))
		{
			int c;
			int counter = 0;

			while ((c = in.read()) != -1)
			{
				out.write(c);
				++counter;
			}

			System.out.println("copyChars - total reads: " + counter);
		}
	}

	private static void copyBytes(final String inFileName, final String outFileName) throws IOException
	{
		try (final FileInputStream in = new FileInputStream(inFileName);
			final FileOutputStream out = new FileOutputStream(outFileName))
		{
			// Copy the file
			System.out.println("copyBytes - total reads: " + copyBytePerByte(in, out));
			//			System.out.println("Total reads: " + copyUsingBuffer(in, out));
		}
	}

	private static int copyUsingBuffer(final FileInputStream in, final FileOutputStream out) throws IOException
	{
		byte[] buffer = new byte[MAX_BYTES];
		int counter = 0;
		int bytesRead;

		while ((bytesRead = in.read(buffer)) != -1)
		{
			out.write(buffer, 0, bytesRead);
			counter++;
		}

		return counter;
	}

	private static int copyBytePerByte(final FileInputStream in, final FileOutputStream out) throws IOException
	{
		int c;
		int counter = 0;

		while ((c = in.read()) != -1)
		{
			out.write(c);
			++counter;
		}

		return counter;
	}
}
