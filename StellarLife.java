package dataStructures;

public class StellarLife 
{
	static class Comparison //Nodes representing each of the comparisons and their sub nodes
	{
		boolean condition;
		String action;
		Comparison left, mid, right;
		Comparison(boolean b)
		{
			this.condition = b;
		}
		public boolean isEmpty()
		{
			boolean isEmpty = false;
			if(left==null&&mid==null&&right==null)
			{
				isEmpty = true;
			}
			return isEmpty;
		}
	}
	static class DecisionTree //Decision Tree that connects the nodes
	{
		Comparison root;
		DecisionTree(boolean condition)
		{
			root = new Comparison(condition);
		}
	}
	static class StellarCycle //Object that holds the Decision Tree and Star information
	{
		String name;
		double mass;
		boolean loseHelium;
		String lifeCycle;
		DecisionTree tree;
		StellarCycle(double m, boolean l,String n)
		{
			this.mass = m;
			this.loseHelium = l;
			this.name = n;
			tree = new DecisionTree(false);
			tree.root = new Comparison(mass>0.0);
			tree.root.action = name+"-->";
			tree.root.left = new Comparison(mass>8);
			tree.root.left.action="Massive Star-->Red Supergiant-->Type II Supernova-->";
			tree.root.mid = new Comparison(mass<8.0&&mass>=0.08);
			tree.root.mid.action = "Low-mass Star-->Red Giant-->";
			
			//If it is a Massive Star
			tree.root.left.left = new Comparison(mass>40);
			tree.root.left.left.action = "Black Hole-->X-ray Emission";
			tree.root.left.right = new Comparison(mass<40);
			tree.root.left.right.action = "Neutron Star-->Pulsar";
			
			//If it is a Low Mass Star
			tree.root.mid.left = new Comparison(loseHelium==true);
			tree.root.mid.left.action = "Binary White Dwarf-->";
			tree.root.mid.left.left = new Comparison(mass>1.4);
			tree.root.mid.left.left.action ="Type 1a Supernova";
			tree.root.mid.left.right = new Comparison(mass<1.4);
			tree.root.mid.left.right.action="Nova-->White Dwarf-->Black Dwarf";
			tree.root.mid.right = new Comparison(!tree.root.mid.left.condition);
			tree.root.mid.right.action = "Planetary Nebula-->White Dwarf-->Black Dwarf";
			
			//If it is a Brown Dwarf
			tree.root.right = new Comparison(!tree.root.left.condition&&!tree.root.mid.condition);
			tree.root.right.action = "Brown Dwarf";
			beginAnalysis(null);
			lifeCycle = lifeCycle.replaceAll("null", "");
		}
		public void beginAnalysis(Comparison decisionTree)
		{
			if(decisionTree==null)
			{
				decisionTree=this.tree.root;
			}
			if(decisionTree.condition==true)
			{
				this.lifeCycle+=decisionTree.action;
				if(decisionTree.left!=null&&decisionTree.left.condition==true)
				{
					beginAnalysis(decisionTree.left);
				}
				else if(decisionTree.right!=null&&decisionTree.right.condition==true)
				{
					beginAnalysis(decisionTree.right);
				}
				else if(decisionTree.mid!=null&&decisionTree.mid.condition==true)
				{
					beginAnalysis(decisionTree.mid);
				}
				else
				{
					return;
				}
			}
		}
		public String toString()
		{
			return ("Name: "+name+"\nMass: "+mass+" times the mass of the Sun\n"+"Lost Helium: "+loseHelium+"\nLife Cycle: "+lifeCycle);
		}
	}
	public static void main(String[] args)
	{
		StellarCycle star = new StellarCycle(1.2,true,"Star");
		System.out.println(star);
	}
}
