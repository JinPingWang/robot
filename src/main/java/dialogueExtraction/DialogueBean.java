package dialogueExtraction;

public class DialogueBean {
	private int dialogueId;
	private String type;
	private String content;
	
	public DialogueBean(int dialogueId, String type, String content){
		this.dialogueId = dialogueId;
		this.type = type;
		this.content = content;
	}

	public int getDialogueId() {
		return dialogueId;
	}

	public void setDialogueId(int dialogueId) {
		this.dialogueId = dialogueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
