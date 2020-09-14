package data.scripts.hullmods;

import java.util.HashMap;
import java.util.Map;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.util.Misc;

public class CHM_COPS extends BaseHullMod
{
    private static final Map mag = new HashMap();
        static {
		mag.put(HullSize.FIGHTER, 10.0f);
        mag.put(HullSize.FRIGATE, 10.0f);
        mag.put(HullSize.DESTROYER, 8.0f);
        mag.put(HullSize.CRUISER, 6.0f);
        mag.put(HullSize.CAPITAL_SHIP, 4.0f);
    }
	
	@Override
    	public void applyEffectsBeforeShipCreation(ShipAPI.HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getSensorProfile().modifyMult(id, 0.9f);
        stats.getFuelUseMod().modifyMult(id, 0.9f);
        stats.getSuppliesPerMonth().modifyMult(id, 0.9f);
        stats.getPeakCRDuration().modifyPercent(id, (Float) mag.get(hullSize));
    }
	
	@Override
	public void applyEffectsAfterShipCreation(ShipAPI ship, String id){
		if ("COPS".equals(Misc.getCommissionFactionId())) {
            ship.getVariant().removeMod("COPS_commission");
        }
        if (ship.getVariant().hasHullMod("CHM_commission")) {
            ship.getVariant().removeMod("CHM_commission");
        }
	}
	
	@Override
	public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "10%";
        if (index == 1) return "8%";
        if (index == 2) return "6%";
        if (index == 3) return "4%";
		if (index == 4) return "10%";
		return null;
    }
    
}
