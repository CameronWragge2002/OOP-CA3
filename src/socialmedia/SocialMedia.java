package socialmedia;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * 
 */
public class SocialMedia implements SocialMediaPlatform {

	ArrayList<socialmedia.Account> accounts = new ArrayList<socialmedia.Account>();
	ArrayList<socialmedia.Post> posts = new ArrayList<socialmedia.Post>();
	ArrayList<Integer> ids = new ArrayList<Integer>();
	ArrayList<Integer> postIds = new ArrayList<Integer>();

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		boolean unique = true;
		int i=0;
		for(socialmedia.Account loopAccount : accounts){
			if(loopAccount.getHandle().equals(handle)){
				unique = false;
			}
			i++;
		}
		if (unique){
			ids.add(ids.size());
			socialmedia.Account newAccount = new socialmedia.Account(ids.size()-1, handle);
			accounts.add(newAccount);
			return ids.get(ids.size()-1);
		} else {
			//#######throw an exception here#######
			return -1;
		}
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		boolean unique = true;
		int i=0;
		for(socialmedia.Account loopAccount : accounts){
			if(loopAccount.getHandle().equals(handle)){
				unique = false;
			}
			i++;
		}
		if (unique){
			ids.add(ids.size());
			socialmedia.Account newAccount = new socialmedia.Account(ids.size()-1, handle, description);
			accounts.add(newAccount);
			return ids.get(ids.size()-1);
		} else {
			//#####throw an exception here######
			return -1;
		}
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub
		int i=0;
		for (socialmedia.Account loopAccount : accounts){
			if(loopAccount.getid() == id){
				accounts.remove(i);
			}
			i++;
		}
	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		int i=0;
		while (i < accounts.size()){
			if(accounts.get(i).getHandle().equals(handle)){
				accounts.remove(i);
			}
			i++;
		}
	}
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
    	for (socialmedia.Account loopAccount : accounts) {
			if (loopAccount.getHandle().equals(oldHandle)) {
				loopAccount.setHandle(newHandle);
			}
		}
	}


	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		for (socialmedia.Account loopAccount : accounts) {
			if (loopAccount.getHandle().equals(handle)) {
				loopAccount.setDescription(description);
			}
		}
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
    	String printedAccount = "";
		for (socialmedia.Account loopAccount : accounts) {
			if (loopAccount.getHandle().equals(handle)) {
				printedAccount.concat("ID: " + Integer.toString(loopAccount.getid()) + "\n" + "Handle: " + loopAccount.getHandle() + "\n" + "Description: " + loopAccount.getDesc() + "\n");
			}
		}
		return printedAccount;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		postIds.add(postIds.size());
		socialmedia.Post newPost = new socialmedia.Post(postIds.size()-1, message, handle);
		posts.add(newPost);
		return postIds.get(postIds.size()-1);
	}

	@Override
	public int endorsePost(String handle, int id) throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		boolean created = false;
    	for (socialmedia.Post loopPost : posts) {
			if (loopPost.getId().equals(id)) {
				created = true;
				postIds.add(postIds.size());
				String message = "EP@" + loopPost.getHandle() + ":" + loopPost.getMessage();
				socialmedia.Post newPost = new socialmedia.Post(postIds.size()-1, message, handle);
				posts.add(newPost);
			}
		}
    	if (created) {
			return postIds.get(postIds.size()-1);
		} else {
    		return -1;
		}
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub
	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}
