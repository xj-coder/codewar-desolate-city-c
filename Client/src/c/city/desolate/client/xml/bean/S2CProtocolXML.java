package c.city.desolate.client.xml.bean;

import java.util.Map;

public class S2CProtocolXML {
	private S2CHeadXML headXML;
	private S2CGameXML gameXML;
	private Map<String, S2CPlayerXML> playerXMLs;
	private S2CMethodXML methodXML;

	public S2CProtocolXML() {
	}

	public S2CHeadXML getHeadXML() {
		return headXML;
	}

	public void setHeadXML(S2CHeadXML headXML) {
		this.headXML = headXML;
	}

	public S2CGameXML getGameXML() {
		return gameXML;
	}

	public void setGameXML(S2CGameXML gameXML) {
		this.gameXML = gameXML;
	}

	public Map<String, S2CPlayerXML> getPlayerXMLs() {
		return playerXMLs;
	}

	public void setPlayerXMLs(Map<String, S2CPlayerXML> playerXMLs) {
		this.playerXMLs = playerXMLs;
	}

	public S2CMethodXML getMethodXML() {
		return methodXML;
	}

	public void setMethodXML(S2CMethodXML methodXML) {
		this.methodXML = methodXML;
	}

}
