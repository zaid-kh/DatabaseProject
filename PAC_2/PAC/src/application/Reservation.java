package application;

import java.util.Calendar;

public class Reservation {
	private int R_ID;
	private int Job_ID;
	private int Customer_ID;
	private Calendar Start_date;
	private Calendar End_date;

	public Reservation(int r_ID, int job_ID, int customer_ID, Calendar start_date, Calendar end_date) {
		super();
		R_ID = r_ID;
		Job_ID = job_ID;
		Customer_ID = customer_ID;
		Start_date = start_date;
		End_date = end_date;

	}

	public int getR_ID() {
		return R_ID;
	}

	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}

	public int getJob_ID() {
		return Job_ID;
	}

	public void setJob_ID(int job_ID) {
		Job_ID = job_ID;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public Calendar getStart_date() {
		return Start_date;
	}

	public void setStart_date(Calendar start_date) {
		Start_date = start_date;
	}

	public Calendar getEnd_date() {
		return End_date;
	}

	public void setEnd_date(Calendar end_date) {
		End_date = end_date;
	}

}