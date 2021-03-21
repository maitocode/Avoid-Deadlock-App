package avoidDeadLock;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class banker {
	int work[];
	boolean finish[];
	int need[][];
	int allocation[][];
	int soTaiNguyen;
	int soTienTrinh;
	int tienTrinhTiepTheo;
	
	int available[];
	int max[][];
	int maxOfTaiNguyen[];
	
	boolean validFlag;
	String errorName;
	
	public banker(String path) throws IOException
	{
		validFlag = true;
		File file = new File (path);
		Scanner sc = new Scanner(file);
		String header = "";	
		while(sc.hasNext())
		{
			if (header.equals("soTaiNguyen"))
			{
				this.soTaiNguyen = sc.nextInt();
				maxOfTaiNguyen = new int[soTaiNguyen];
				for (int i = 0; i < soTaiNguyen; i++)
				{
					maxOfTaiNguyen[i] = sc.nextInt();
				}
				header = "";
			}
			else if (header.equals("soTienTrinh"))
			{
				this.soTienTrinh = sc.nextInt();
				this.allocation = new int[soTienTrinh][soTaiNguyen];
				
				for (int i = 0; i < soTienTrinh; i++)
				{
					for (int j = 0; j < soTaiNguyen; j++)
					{
						allocation[i][j] = sc.nextInt();
					}
				}
				header = "";
			}
			else if (header.equals("maxOfTienTrinh"))
			{
				max = new int[soTienTrinh][soTaiNguyen];
				for (int i = 0; i < soTienTrinh; i++)
				{
					for (int j = 0; j < soTaiNguyen; j++)
					{
						max[i][j] = sc.nextInt();
					}
				}
			}
			else header = sc.next();
		}
		
		finish = new boolean[soTienTrinh];
		for (int i = 0; i < soTienTrinh; i++)
		{
			finish[i] = false;
		}
		
		work = new int[soTaiNguyen];
		for (int i = 0; i < soTaiNguyen; i++)
		{
			work[i] = maxOfTaiNguyen[i];
			for (int j = 0; j < soTienTrinh; j++)
			{
				work[i] -= allocation[j][i];
			}
			if (work[i] < 0) 
			{
				validFlag = false;
				errorName = "Không đủ dung lượng cấp phát";
			}
				
		}
		
		need = new int[soTienTrinh][soTaiNguyen];
		for (int i = 0; i < soTienTrinh; i++)
		{
			for (int j = 0; j < soTaiNguyen; j++)
			{
				need[i][j] = max[i][j] - allocation[i][j];
				if (need[i][j] < 0) 
				{
					validFlag = false;
					errorName = "Invalid Input!";
				}
			}
		}

		sc.close();
	}
	
	int tienTrinhTiepTheo()
	{
		for (int i = 0; i < soTienTrinh; i++)
		{
			if (!finish[i])
			{
				int a = 0;
				for (int j = 0; j < soTaiNguyen; j++)
				{
					if (need[i][j] <= work[j])
						a++;
					else break;
				}
				if (a == soTaiNguyen) return i;
			}
		}
		return -1;
	}
	
	String getSafeString()
	{
		if (!validFlag) return errorName;
		String safeString = "► ";
		
		for (int i = 0; i < soTienTrinh; i++)
		{
			int index = tienTrinhTiepTheo();
			if (index != -1)
			{
				finish[index] = true;
				for (int j = 0; j < soTaiNguyen; j++)
				{
					work[j] += allocation[index][j];
				}
				
				if (i == (soTienTrinh - 1))
					safeString += "P" + String.valueOf(index + 1) + "";
				else
					safeString += "P" + String.valueOf(index + 1) + " → ";
			}
			else return "This maybe have DeadLock";
		}
		return safeString;
	}
	
	int getSoTaiNguyen()
	{
		return soTaiNguyen;
	}
	
	int getSotienTrinh()
	{
		return soTienTrinh;
	}
	
	int getCapacity(int index)
	{
		if (index > soTaiNguyen)
			return 0;
		else return maxOfTaiNguyen[--index];
	}
	
	int getAllocation(int index1, int index2)
	{
		if (index1 > soTienTrinh || index2 > soTaiNguyen)
			return 0;
		else return allocation[--index1][--index2];
	}
	
	int getNeed(int index1, int index2)
	{
		if (index1 > soTienTrinh || index2 > soTaiNguyen)
			return 0;
		else return need[--index1][--index2];
	}
}