package rs.ac.ni.pmf.streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Streams2Demo
{
	static final String dataFile = "invoicedata.dat";
	static final String studentsFile = "students.dat";

	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descriptions = {
		"Java T-shirt",
		"Java Mug",
		"Duke Juggling Dolls",
		"Java Pin",
		"Java Key Chain"
	};

	public static void main(String[] args) throws IOException
	{
		//		bufferedStreams();
		//		writeData();
		//		readData();
//		writeStudents();
		readStudents();
	}

	private static void readStudents() throws IOException
	{
		try (final ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentsFile)))
		{
			final Student student = (Student)in.readObject();
			System.out.println(student.toString());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Error, cannot read data: " + e.getMessage());
		}
	}

	private static void writeStudents() throws IOException
	{
		final Student student = new Student();
		student.setId(1);
		student.setFirstName("Mika");
		student.setLastName("Mikic");

		try (final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentsFile)))
		{
			out.writeObject(student);
		}
	}

	private static void writeData() throws IOException
	{
		try (final DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile))))
		{
			for (int i = 0; i < prices.length; ++i)
			{
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descriptions[i]);
			}
		}
	}

	private static void readData() throws IOException
	{
		try (final DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile))))
		{
			while (true)
			{
				double price = in.readDouble();
				int unit = in.readInt();
				String description = in.readUTF();

				System.out.println(String.format("(price, unit, description) = (%4.2f, %d, %s)", price, unit, description));
			}
		}
		catch (EOFException e)
		{
			// Ignore the exception
			System.out.println("Read done.");
		}
	}

	private static void bufferedStreams() throws IOException
	{
		try (final BufferedReader in = new BufferedReader(
			new InputStreamReader(
				new FileInputStream("letters.txt"),
				StandardCharsets.UTF_8)))
		{
			String line;
			while ((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
		}
	}
}
