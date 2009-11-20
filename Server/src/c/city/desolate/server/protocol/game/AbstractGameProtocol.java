package c.city.desolate.server.protocol.game;

import c.city.desolate.server.xml.bean.C2SProtocolXML;

public abstract class AbstractGameProtocol {

	public abstract byte[] commitProtocol(C2SProtocolXML protocolXML);
}
