package rs.ac.ni.pmf.streams;

import java.io.*;

public class Student implements Externalizable // implements Serializable
{
	private int id;
	private String firstName;
	private String lastName;

	public Student()
	{
	}

	public Student(int id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "Student{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			'}';
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeInt(id);
		out.writeUTF(firstName);
		out.writeUTF(lastName);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException
	{
		this.id = in.readInt();
		this.firstName = in.readUTF();
		this.lastName = in.readUTF();
	}
}
