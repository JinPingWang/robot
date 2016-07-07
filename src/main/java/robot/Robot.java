package robot;

import java.io.IOException;

public interface Robot {
	String getReply(String content, String useId) throws IOException;
}
