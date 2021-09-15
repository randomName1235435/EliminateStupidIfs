
public class SuccessMessageCreator implements MessageCreator {

	@Override
	public Message create() {
		return new Message("success");
	}
}
