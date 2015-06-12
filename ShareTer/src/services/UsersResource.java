package services;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;


public class UsersResource {

	public static ArrayNode getAllRegIds() {
		ArrayNode lstRegIds = new ArrayNode(JsonNodeFactory.instance);
		
		lstRegIds.add("APA91bFAILjWNmvSczxE4TbedB1cmZ2umGWB2Y48SCbVG21eKgjNvzQaxUrlvIvMweiepixG-mosxEmu9na4A0Mv_RhmEF1BvDLP3m8Gr_ID7LECxBdHWEVoDx1h7D3JLQzjMrXC2w_InC1U-H5IhRThFPFiu8ro3w");

		return lstRegIds;
	}
}
