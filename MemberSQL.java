package proj.sql;

public class MemberSQL {
	
	public static final int SEL_ALL_MEMB 	= 1001; // 모든 회원 정보 조회
	public static final int SEL_ALL_ID	= 1002; // 모든 아이디 조회



	public static String getMSQL(int code) {
		StringBuffer buff = new StringBuffer();

	// 회원추가
		switch(code) {
			case SEL_ALL_ID:
				buff.append("SELECT ");
				buff.append("    id ");
				buff.append("FROM ");
				buff.append("    member ");
				buff.append("WHERE ");
				buff.append("    isshow = 'Y' ");
				break;
			case SEL_ALL_MEMB:
				buff.append("SELECT ");
				buff.append("	mno, name, id, pw, mail, tel, gen, avatar, joindate, isshow ");
				buff.append("FROM ");
				buff.append("	member ");
				buff.append("WHERE ");
				buff.append("	b.isshow = 'Y' ");
				break;

		}

	// 질의명령 반환함수
		return buff.toString();
	}


}
