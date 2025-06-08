class Trie
{
    int val;
    Trie[] child;
    boolean isLeaf;
    public Trie(int val)
    {
        this.val=val;
        child=new Trie[10];
        isLeaf=false;
    }
}
class Solution {
    public void insert(String x,Trie t)
    {
        for(char c:x.toCharArray())
        {
            int z=c-'0';
            if(t.child[z]==null)
                t.child[z]=new Trie(z);
            t=t.child[z];
        }
        t.isLeaf=true;
    }
    public void sort(Trie t,String s,List<Integer> res)
    {
        if(t==null)
            return;
        if(t.isLeaf)
        {
            res.add(Integer.valueOf(s));
        }
        for(int i=0;i<10;i++)
        {
            if(t.child[i]!=null)
                sort(t.child[i],(s+t.child[i].val),res);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        Trie t=new Trie(0);
        for(int i=1;i<=n;i++)
            insert(String.valueOf(i),t);
        List<Integer> res=new ArrayList<>();
        sort(t,"",res);
        return res;
    }
}