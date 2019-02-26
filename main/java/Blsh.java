public enum Blsh {
	YES(1,"y"),NO(0,"n");

	private int code;
	private String msg;

	Blsh() {
	}

	Blsh(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
