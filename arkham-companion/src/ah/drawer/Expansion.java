package ah.drawer;

public class Expansion {

	private long ID;
	private String name;

	public Expansion(long ID, String name)
	{
		this.ID = ID;
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public String getName() {
		return name;
	}
	
    @Override public String toString()
    {
    	return getName();
    }

	public boolean getApplied() {
		
		return AHFlyweightFactory.INSTANCE.getAppliedExpansions().containsKey(ID);
	}
	
	public String getCheckboxOffPath()
	{
		switch ((int)ID)
		{
			case 1: return "checkbox/btn_dh_check_off.png";
			case 2: return "checkbox/btn_dp_check_off.png";
			case 3: return "checkbox/btn_dh_check_off.png";
			case 4: return "checkbox/btn_ky_check_off.png";
			case 5: return "checkbox/btn_kh_check_off.png";
			case 6: return "checkbox/btn_bg_check_off.png";
			case 7: return "checkbox/btn_ih_check_off.png";
			case 8: return "checkbox/btn_lt_check_off.png";
			case 9: return "checkbox/btn_dp_check_off.png";
			case 10: return "checkbox/btn_dh_check_off.png";
			default: return "checkbox/btn_dh_check_off.png";
		}
	}
	
	public String getCheckboxOnPath()
	{
		switch ((int)ID)
		{
			case 1: return "checkbox/btn_dh_check_on.png";
			case 2: return "checkbox/btn_dp_check_on.png";
			case 3: return "checkbox/btn_dh_check_on.png";
			case 4: return "checkbox/btn_ky_check_on.png";
			case 5: return "checkbox/btn_kh_check_on.png";
			case 6: return "checkbox/btn_bg_check_on.png";
			case 7: return "checkbox/btn_ih_check_on.png";
			case 8: return "checkbox/btn_lt_check_on.png";
			case 9: return "checkbox/btn_dp_check_on.png";
			case 10: return "checkbox/btn_dh_check_on.png";
			default: return "checkbox/btn_dh_check_on.png";
		}
	}
}
