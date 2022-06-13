import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class BookRist
{
	static
	{
		try
		{
 			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}

	Connection con;
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
	PreparedStatement pstmt3;
	PreparedStatement pstmt4;
	PreparedStatement pstmt5;
	PreparedStatement pstmt6;
	PreparedStatement pstmt7;
	PreparedStatement pstmt8;
	PreparedStatement pstmt9;
	PreparedStatement pstmt10;
	PreparedStatement pstmt11;
	PreparedStatement pstmt12;
	PreparedStatement pstmt13;
	PreparedStatement pstmt14;
	PreparedStatement pstmt15;
	PreparedStatement pstmt16;
	PreparedStatement pstmt17;
	PreparedStatement pstmt18;
	PreparedStatement pstmt19;
	PreparedStatement pstmt20;
	PreparedStatement pstmt21;
	PreparedStatement pstmt22;
	PreparedStatement pstmt23;
	PreparedStatement pstmt24;
	PreparedStatement pstmt25;
	PreparedStatement pstmt26;
	PreparedStatement pstmt27;
	PreparedStatement pstmt28;
	PreparedStatement pstmt29;
	String[] className = {"철학", "종교", "사회과학", "자연과학", "기술과학", "예술", "언어", "문학", "역사"};
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		BookRist pb = new BookRist();
		pb.doRun();
	}

	public void doRun()
	{
		connectDatabase();
		int choice;

		while(true)
		{
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			enter();
			switch(choice)
			{
			case 1:
				bookRun();
				break;
			case 2:
				userRun();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void showMenu()
	{
		enter();
		System.out.println("[메뉴 선택]");
		System.out.println("1.도서 행정");
		System.out.println("2.회원 행정");
		System.out.println("0.종료");
		System.out.print("선택 : ");
	}

	public void bookMenu()
	{
		enter();
		System.out.println("1.책 등록");
		System.out.println("2.책 조회");
		System.out.println("3.책 삭제");
		System.out.println("4.책 대여");
		System.out.println("5.책 반납");
		System.out.println("6.분류별 도서 목록");
		System.out.println("7.전체 도서 목록");
		System.out.println("0.이전 메뉴");
	}

	public void userMenu()
	{
		enter();
		System.out.println("1.회원가입");
		System.out.println("2.연장 신청");
		System.out.println("3.전체 회원 정보");
		System.out.println("0.이전 메뉴");
	}

	public void bookRun()
	{
		int choice;

		while(true)
		{
			bookMenu();
			choice = sc.nextInt();
			sc.nextLine();
			enter();
			switch(choice)
			{
			case 1:
				addInfo();
				break;
			case 2:
				selMain();
				break;
			case 3:
				delMain();
				break;
			case 4:
				rent();
				break;
			case 5:
				give();
				break;
			case 6:
				classBook();
				break;
			case 7:
				bookBase();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void userRun()
	{
		int choice;

		while(true)
		{
			userMenu();
			choice = sc.nextInt();
			sc.nextLine();
			enter();
			switch(choice)
			{
			case 1:
				newId();
				break;
			case 2:
				extension();
				break;
			case 3:
				idBase();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void selMain()
	{
		int ask;

		while(true)
		{
			System.out.println("1.번호 조회");
			System.out.println("2.제목 조회");
			System.out.println("3.이전 메뉴");
			ask = sc.nextInt();
			sc.nextLine();

			switch(ask)
			{
			case 1:
				numInfo();
				break;
			case 2:
				strInfo();
				break;
			case 3:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				return;
			default :
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void delMain()
	{
		int ask;

		while(true)
		{
			System.out.println("1.번호로 삭제");
			System.out.println("2.제목으로 삭제");
			System.out.println("3.이전 메뉴");
			ask = sc.nextInt();
			sc.nextLine();

			switch(ask)
			{
			case 1:
				numDel();
				break;
			case 2:
				strDel();
				break;
			case 3:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				return;
			default :
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void addInfo()
	{
		int number;
		String classfication;
		String bookName;
		String writerName;
		int volume;

		MyExit: while(true)
		{
			System.out.println("등록할 책의 정보를 입력하세요.");
			System.out.println();
			System.out.print("번호 : ");
			number = sc.nextInt();
			sc.nextLine();
			if(number < 1000 || 9999 < number)
			{
				System.out.println("입력이 올바르지 않습니다.");
				continue;
			}
			else
			{
				String sql2 = "select 번호 from bookbase where 번호 = ?";
				try
				{
					pstmt15 = con.prepareStatement(sql2);
					pstmt15.setInt(1, number);
					ResultSet rs = pstmt15.executeQuery();

					if(rs.next())
					{
						if(rs.getInt(1) == number)
						{
							System.out.println("이미 있는 번호입니다.");
							continue;
						}
					}
					rs.close();
					pstmt15.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			System.out.print("분류 : ");
			classfication = sc.nextLine();

			int count = 0;
			for(int i = 0; i < 9; i++)
			{
				if(classfication.equals(className[i]))
				{
					break;
				}
				else
					count++;
			}
			if(count == 9)
			{
				System.out.println("입력이 올바르지 않습니다.");
				System.out.println("다시 입력하세요.");
				continue;
			}

			System.out.print("제목 : ");
			bookName = sc.nextLine();
			System.out.print("작가 : ");
			writerName  = sc.nextLine();
			System.out.print("입고수량 : ");
			volume = sc.nextInt();
			sc.nextLine();

			String sql = "insert into bookbase values(?, ?, ?, ?, ?, ?, ?)";

			try
			{
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setInt(1, number);
				pstmt1.setString(2, classfication);
				pstmt1.setString(3, bookName);
				pstmt1.setString(4, writerName);
				pstmt1.setInt(5, volume);
				pstmt1.setInt(6, volume);
				pstmt1.setInt(7, 0);
				int updateCount = pstmt1.executeUpdate();
				System.out.println("데이터베이스에 추가되었습니다.");

				pstmt1.close();
			}
			catch(Exception e)
			{
				System.out.println("데이터베이스 입력 에러입니다.");
			}

			while(true)
			{
				System.out.println("등록을 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
				{
					enter();
					break;
				}
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void numInfo()
	{
		int bookNumber;

		MyExit: while(true)
		{
			System.out.println("조회할 책의 번호를 입력하세요.");
			bookNumber = sc.nextInt();
			sc.nextLine();

			if(bookNumber < 1000 || 9999 < bookNumber)
			{
				System.out.println("입력이 올바르지 않습니다.");
				continue;
			}

			enter();

			String sql = "select * from bookbase where 번호 = ?";
			try
			{
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, bookNumber);
				ResultSet rs = pstmt2.executeQuery();

				if(rs.next())
				{
					System.out.println("번호 : " + rs.getString(1));
					System.out.println("분류 : " + rs.getString(2));
					System.out.println("제목 : " + rs.getString(3));
					System.out.println("작가 : " + rs.getString(4));
					System.out.println("잔여수량 : " + rs.getString(5));
					System.out.println("누적대여량 : " + rs.getString(6));
				}
				else
				{
					System.out.println("조회한 책이 없습니다.");
				}
				rs.close();
				pstmt2.close();
			}
			catch(Exception e)
			{
				System.out.println("잘 못 입력하였습니다.");
			}

			while(true)
			{
				System.out.println("조회를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void strInfo()
	{
		MyExit: while(true)
		{
			System.out.println("조회할 책의 제목을 입력하세요.");
			String name = sc.nextLine();

			enter();

			String sql = "select * from bookbase where 제목 = ?";
			try
			{
				pstmt3 = con.prepareStatement(sql);
				pstmt3.setString(1,name);
				ResultSet rs = pstmt3.executeQuery();

				if(rs.next())
				{
					System.out.println("번호 : " + rs.getString(1));
					System.out.println("분류 : " + rs.getString(2));
					System.out.println("제목 : " + rs.getString(3));
					System.out.println("작가 : " + rs.getString(4));
					System.out.println("잔여수량 : " + rs.getString(5));
					System.out.println("누적대여량 : " + rs.getString(6));
				}
				rs.close();
				pstmt3.close();
			}
			catch(Exception e)
			{
				System.out.println("조회한 책이 없습니다.");
			}

			while(true)
			{
				System.out.println("조회를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void numDel()
	{
		MyExit: while(true)
		{
			System.out.println("삭제할 책의 번호를 입력하세요.");
			int bookNumber = sc.nextInt();
			sc.nextLine();

			if(bookNumber < 1000 || 9999 < bookNumber)
			{
				System.out.println("입력이 올바르지 않습니다.");
				continue;
			}

			String sql = "delete from bookbase where 번호 = ?";
			try
			{
				pstmt4 = con.prepareStatement(sql);
				pstmt4.setInt(1, bookNumber);
				int updateCount = pstmt4.executeUpdate();
				ResultSet rs = pstmt4.executeQuery();

				if(updateCount == 1)
				{
					enter();
					System.out.println("데이터베이스에서 삭제되었습니다.");
				}
				else if(rs.next())
				{
					enter();
					System.out.println("해당 책이 없습니다.");
				}

				rs.close();
				pstmt4.close();
			}
			catch(Exception e)
			{
				enter();
				System.out.println("해당 책이 없습니다.");
			}

			while(true)
			{
				System.out.println("삭제를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void strDel()
	{
		MyExit: while(true)
		{
			System.out.println("삭제할 책의 제목을 입력하세요.");
			String name = sc.nextLine();

			String sql = "delete from bookbase where 제목 = ?";
			try
			{
				pstmt5 = con.prepareStatement(sql);
				pstmt5.setString(1, name);
				int updateCount = pstmt5.executeUpdate();
				ResultSet rs = pstmt5.executeQuery();

				if(updateCount == 1)
				{
					enter();
					System.out.println("데이터베이스에서 삭제되었습니다.");
				}
				else if(rs.next())
				{
					enter();
					System.out.println("해당 책이 없습니다.");
				}

				rs.close();
				pstmt5.close();
			}
			catch(Exception e)
			{
				enter();
				System.out.println("해당 책이 없습니다.");
			}

			while(true)
			{
				System.out.println("삭제를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void rent()
	{
		int zero = 0;

		MyExit: while(true)
		{
			while(true)
			{
				System.out.println("대여자의 아이디를 입력하세요.");
				String id = sc.nextLine();

				String sql5 = "select 아이디, 블랙여부 from idbase where 아이디 = ?";
				try
				{
					pstmt16 = con.prepareStatement(sql5);
					pstmt16.setString(1, id);
					ResultSet rs3 = pstmt16.executeQuery();

					if(rs3.next())
					{
						if((rs3.getString(2)).equals("블랙"))
						{
							System.out.println("연체패널티로 대여가 불가합니다.");
							sc.nextLine();
						}
						else
						{
							if(id.equals(rs3.getString(1)))
							{
								System.out.println("대여할 책의 이름을 입력하세요.");
								String bookName = sc.nextLine();

								String sql4 = "select 잔여수량 from bookbase where 제목 = ?";

								try
								{
									pstmt6 = con.prepareStatement(sql4);
									pstmt6.setString(1, bookName);
									ResultSet rs2 = pstmt6.executeQuery();

									if(rs2.next())
									{
										if(rs2.getInt(1) > 0)
										{
											String sql = "insert into info values(?,?,sysdate,sysdate+7,null,'미납')";
											try
											{
												pstmt7 = con.prepareStatement(sql);
												pstmt7.setString(1, id);
												pstmt7.setString(2, bookName);
												ResultSet rs = pstmt7.executeQuery();

												if(rs.next())
												{
													System.out.println("대여 목록에 추가되었습니다.");
												}
												rs.close();
												pstmt7.close();
											}
											catch(Exception e)
											{
												System.out.println("잘 못 입력하였습니다.");
											}
										}
										else if(rs2.getInt(1) == 0)
										{
											zero++;
											System.out.println("잔여수량이 없습니다.");
										}
									}
									rs2.close();
									pstmt6.close();
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}

								if(zero == 0)
								{
									String sql2 = "update bookbase set 잔여수량 = 잔여수량 -1 where 제목 = ?";
									String sql3 = "update bookbase set 누적대여량 = 누적대여량 +1 where 제목 = ?";
									try
									{
										pstmt8 = con.prepareStatement(sql2);
										pstmt8.setString(1, bookName);
										int updateCount = pstmt8.executeUpdate();
										pstmt9 = con.prepareStatement(sql3);
										pstmt9.setString(1, bookName);
										int updateCount2 = pstmt9.executeUpdate();

										pstmt8.close();
										pstmt9.close();
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
								}
							}
						}
						rs3.close();
						pstmt16.close();
						break;
					}
					else
					{
						System.out.println("등록되지 않은 아이디입니다.");
						while(true)
						{
							System.out.println("다시 입력하시겠습니까? ( 네 / 아니오 )");
							String more = sc.nextLine();

							if(more.equals("네"))
								break;
							else if(more.equals("아니오"))
								break MyExit;
							else
							{
								System.out.println("잘 못 입력했습니다.");
								continue;
							}
						}
						continue;
					}
				}
				catch(Exception e)
				{
					System.out.println("등록되지 않은 아이디입니다.");
					break MyExit;
				}
			}

			while(true)
			{
				System.out.println("대여를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
				{
					System.out.println("잘 못 입력했습니다.");
					continue;
				}
			}
		}
	}

	public void give()
	{
		Date today;
		Date give;

		MyExit: while(true)
		{
			System.out.println("반납자의 아이디 입력하세요.");
			String id = sc.nextLine();
			System.out.println("반납할 책의 이름을 입력하세요.");
			String bookName = sc.nextLine();

			String sql3 = "select 반납여부 from info where 아이디 = ? and 대여책 = ?";
			try
			{
				pstmt12 = con.prepareStatement(sql3);
				pstmt12.setString(1, id);
				pstmt12.setString(2, bookName);
				ResultSet rs2 = pstmt12.executeQuery();

				if(rs2.next())
				{
					if(rs2.getString(1).equals("미납"))
					{
						String sql = "update info set 반납일자 = sysdate, 반납여부 = '반납완료' where 아이디 = ? and 대여책 = ?";
						try
						{
							pstmt10 = con.prepareStatement(sql);
							pstmt10.setString(1, id);
							pstmt10.setString(2, bookName);
							int updateCount2 = pstmt10.executeUpdate();
							ResultSet rs = pstmt10.executeQuery();

							if(rs.next())
							{
								String sql4 = "select 반납예정일, 반납일자 from info where 아이디 = ? and 대여책 = ?";
								try
								{
									pstmt17 = con.prepareStatement(sql4);
									pstmt17.setString(1, id);
									pstmt17.setString(2, bookName);
									ResultSet rs3 = pstmt17.executeQuery();
									if(rs3.next())
									{
										give = rs3.getDate(1);
										today = rs3.getDate(2);
										if(today.compareTo(give) > 0)
										{
											String sql5 = "update idbase set 블랙여부 = '블랙' where 아이디 = ?";
											try
											{
												pstmt18 = con.prepareStatement(sql5);
												pstmt18.setString(1, id);
												int updateCount3 = pstmt18.executeUpdate();

												pstmt18.close();
											}
											catch(Exception e)
											{
												e.printStackTrace();
											}
										}
									}
									rs3.close();
									pstmt17.close();
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}

								System.out.println("반납이 완료되었습니다.");
							}
							rs.close();
							pstmt10.close();
						}
						catch(Exception e)
						{
							System.out.println("잘 못 입력했습니다.");
						}

						String sql2 = "update bookbase set 잔여수량 = 잔여수량 +1 where 제목 = ?";
						try
						{
							pstmt11 = con.prepareStatement(sql2);
							pstmt11.setString(1, bookName);
							int updateCount = pstmt11.executeUpdate();

							pstmt11.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else if(rs2.getString(1).equals("반납완료"))
					{
						System.out.println("이미 반납하였습니다");
					}
				}
				else
				{
					System.out.println("대여 기록이 없습니다.");
				}
				rs2.close();
				pstmt12.close();
			}
			catch(Exception e)
			{
				System.out.println("대여 기록이 없습니다.");
			}

			while(true)
			{
				System.out.println("반납를 더 하시겠습니까? ( 네 / 아니오 )");
				String more = sc.nextLine();

				if(more.equals("네"))
					break;
				else if(more.equals("아니오"))
					break MyExit;
				else
					continue;
			}
		}
	}

	public void extension()
	{
		System.out.println("대여자의 아이디를 입력하세요.");
		String id = sc.nextLine();
		System.out.println("대여한 책 제목을 입력하세요.");
		String bookName = sc.nextLine();

		String sql = "select trunc(반납예정일,'dd') - trunc(대여일자,'dd') from info where 아이디 = ? and 대여책 = ? and 반납여부 = '미납'";
		try
		{
			pstmt24 = con.prepareStatement(sql);
			pstmt24.setString(1, id);
			pstmt24.setString(2, bookName);
			ResultSet rs = pstmt24.executeQuery();

			if(rs.next())
			{
				if(rs.getInt(1) < 14)
				{
					String sql2 = "update info set 반납예정일 = 반납예정일 + 7 where 아이디 = ? and 대여책 = ? and 반납여부 = '미납'";
					try
					{
						pstmt25 = con.prepareStatement(sql2);
						pstmt25.setString(1, id);
						pstmt25.setString(2, bookName);
						int updateCount = pstmt25.executeUpdate();

						enter();
						System.out.println("연장이 완료되었습니다.");

						pstmt25.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					enter();
					System.out.println("이미 연장되었습니다.");
				}
			}
			else
			{
				System.out.println("미납목록에 없습니다.");
			}
			rs.close();
			pstmt24.close();
		}
		catch(Exception e)
		{
			enter();
			System.out.println("대여 목록이 없습니다.");
		}

		System.out.println("이전 메뉴로 돌아가려면 엔터를 누르세요.");
		sc.nextLine();
	}

	public void newId()
	{
		MyExit: while(true)
		{
			System.out.print("신규 아이디 입력 : ");
			String id = sc.nextLine();

			String sql2 = "select 아이디 from idbase where 아이디 = ?";
			try
			{
				pstmt14 = con.prepareStatement(sql2);
				pstmt14.setString(1, id);
				ResultSet rs2 = pstmt14.executeQuery();

				if(rs2.next())
				{
					if(id.equals(rs2.getString(1)))
					{
						System.out.println();
						System.out.println();
						System.out.println("중복된 아이디입니다.");
						System.out.println();
						System.out.println();
						continue;
					}
				}
				rs2.close();
				pstmt14.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			while(true)
			{
				System.out.print("비밀번호 입력 : ");
				String pw = sc.nextLine();
				System.out.print("비밀번호 확인 : ");
				String rPw = sc.nextLine();

				if(pw.equals(rPw))
				{
					System.out.print("본인 성명 입력 : ");
					String name = sc.nextLine();

					String sql = "insert into idbase values(?, ?, ?, '화이트',null)";
					try
					{
						pstmt13 = con.prepareStatement(sql);
						pstmt13.setString(1, id);
						pstmt13.setString(2, pw);
						pstmt13.setString(3, name);
						int updateCount = pstmt13.executeUpdate();

						System.out.println("회원가입이 완료되었습니다.");

						pstmt13.close();
					}
					catch(Exception e)
					{
						System.out.println("입력이 올바르지 않습니다.");
					}
				}
				else
				{
					System.out.println("비밀번호가 맞지 않습니다.");
					break;
				}
				System.out.println("이전 메뉴로 돌아가려면 엔터를 누르세요.");
				sc.nextLine();
				break MyExit;
			}
		}
	}

	public void bookBase()
	{
		System.out.println("번호" + " " + "분류" + " " + "제목" + "  " + "작가" + " " + "전체수량" + " " + "잔여수량" + " " + "누적대여량");
		String sql = "select * from bookbase order by 번호";
		try
		{
			pstmt19 = con.prepareStatement(sql);
			ResultSet rs = pstmt19.executeQuery();

			while(rs.next())
			{
				int bookNumber = rs.getInt(1);
				String classfication = rs.getString(2);
				String bookName = rs.getString(3);
				String writerName = rs.getString(4);
				int volume = rs.getInt(5);
				int remain = rs.getInt(6);
				int accrue = rs.getInt(7);

				System.out.println(bookNumber + " " + classfication + " " + bookName + " " + writerName + "    " + volume + "      " + remain + "        " + accrue);
			}
			rs.close();
			pstmt19.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("이전 메뉴로 돌아가려면 엔터를 누르세요.");
		sc.nextLine();
	}

	public void classBook()
	{
		System.out.println("조회할 분류");
		System.out.println("1. 1000 : 철학");
		System.out.println("2. 2000 : 종교");
		System.out.println("3. 3000 : 사회과학");
		System.out.println("4. 4000 : 자연과학");
		System.out.println("5. 5000 : 기술과학");
		System.out.println("6. 6000 : 예술");
		System.out.println("7. 7000 : 언어");
		System.out.println("8. 8000 : 문학");
		System.out.println("9. 9000 : 역사");
		int select = sc.nextInt();
		sc.nextLine();

		enter();

		System.out.println("번호" + " " + "분류" + " " + "제목" + "  " + "작가" + " " + "전체수량" + " " + "잔여수량" + " " + "누적대여량");
		String sql = "select * from bookbase where 번호 > " + select + "000 and 번호 < " + (select+1) + "000 order by 번호";
		try
		{
			pstmt21 = con.prepareStatement(sql);
			ResultSet rs = pstmt21.executeQuery();


			while(rs.next())
			{
				int bookNumber = rs.getInt(1);
				String classfication = rs.getString(2);
				String bookName = rs.getString(3);
				String writerName = rs.getString(4);
				int volume = rs.getInt(5);
				int remain = rs.getInt(6);
				int accrue = rs.getInt(7);

				System.out.println(bookNumber + " " + classfication + " " + bookName + " " + writerName + "    " + volume + "      " + remain + "        " + accrue);
			}
			rs.close();
			pstmt21.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("이전 메뉴로 돌아가려면 엔터를 누르세요.");
		sc.nextLine();
	}

	public void idBase()
	{

		System.out.println("아이디   비밀번호    이름   블랙여부");
		String sql = "select * from idbase";
		try
		{
			pstmt20 = con.prepareStatement(sql);
			ResultSet rs = pstmt20.executeQuery();


			while(rs.next())
			{
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String block = rs.getString(4);

				System.out.println(id + "   " + pw + "     " + name + "   " + block);
			}
			rs.close();
			pstmt20.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("이전 메뉴로 돌아가려면 엔터를 누르세요.");
		sc.nextLine();
	}

	public void connectDatabase()
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}



		String sql5 = "create table bookbase(번호 number(4),분류 varchar(20),제목 varchar(20),작가 varchar(20),전체수량 number(10),잔여수량 number(10),누적대여량 number(10))";
		try
		{
			pstmt5 = con.prepareStatement(sql5);
			int updateCount3 = pstmt5.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		String sql6 = "create table info(아이디 varchar(20),대여책 varchar(20),대여일자 date,반납예정일 date,반납일자 date,반납여부 varchar(20))";
		try
			{
				pstmt28 = con.prepareStatement(sql6);
				int updateCount4 = pstmt28.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		String sql7 = "create table idbase(아이디 varchar(20),비밀번호 varchar(20), 이름 varchar(20), 블랙여부 varchar(20), 대여제한기간 number(10))";
		try
			{
				pstmt29 = con.prepareStatement(sql7);
				int updateCount4 = pstmt29.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


		String sql = "select 아이디, trunc(반납일자,'dd') - trunc(반납예정일,'dd'), trunc(sysdate,'dd') - trunc(반납일자,'dd') from info where 반납여부 = '반납완료'";

		try
		{
			pstmt22 = con.prepareStatement(sql);
			ResultSet rs = pstmt22.executeQuery();

			while(rs.next())
			{
				String id = rs.getString(1);
				int block = rs.getInt(2);
				int blockDay = block * 2;
				int white = rs.getInt(3);
				int resultBlock = blockDay - white;

				if(resultBlock < 0)
				{
					resultBlock = 0;
				}
				String sql4 = "update idbase set 대여제한기간 = ? where 아이디 = ?";
				String sql3 = "commit";
				try
				{
					pstmt27 = con.prepareStatement(sql4);
					pstmt27.setInt(1, resultBlock);
					pstmt27.setString(2, id);
					int updateCount2 = pstmt27.executeUpdate();
					pstmt26 = con.prepareStatement(sql3);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				if(block > 0)
				{
					if(white >= blockDay)
					{
						String sql2 = "update idbase set 블랙여부 = '화이트'where 아이디 = ?";

						try
						{
							pstmt23 = con.prepareStatement(sql2);
							pstmt23.setString(1, id);
							int updateCount = pstmt23.executeUpdate();
							pstmt26 = con.prepareStatement(sql3);

							pstmt26.close();
							pstmt23.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}
			rs.close();
			pstmt22.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void enter()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}