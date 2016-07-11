package robot;

import java.io.IOException;

import javax.servlet.http.HttpSession;

public interface Robot {
	String getReply(String content, HttpSession userSesson) throws IOException;
}
