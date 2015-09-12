public class Employee {
	private String name;
	private int phoneSkill;
	private int repairSkill;
	private int networkSkill;
	
	public Employee(String s, int pS, int rS, int nS){
		name = s;
		phoneSkill = pS;
		repairSkill = rS;
		networkSkill = nS;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneSkill() {
		return phoneSkill;
	}

	public void setPhoneSkill(int phoneSkill) {
		this.phoneSkill = phoneSkill;
	}

	public int getRepairSkill() {
		return repairSkill;
	}

	public void setRepairSkill(int repairSkill) {
		this.repairSkill = repairSkill;
	}

	public int getNetworkSkill() {
		return networkSkill;
	}

	public void setNetworkSkill(int networkSkill) {
		this.networkSkill = networkSkill;
	}
	
}