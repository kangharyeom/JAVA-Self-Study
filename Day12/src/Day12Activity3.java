public class Day12Activity3 {
	public static void main(String[] args) {
		haryeom c = new haryeom(1,2,3);
		c.method();
		
	}
}

class kang {
	int x, y;
	
	kang(int x, int y){
		this.x=x;
		this.y=y;
		
	}
}

class haryeom extends kang {
	int z;
	
	haryeom(int x, int y,int z) {
	super(x,y);
	this.z=z;
	
	}
	void method() {
		System.out.println(x+y+z);	
	}
}