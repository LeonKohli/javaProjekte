//Arrays sortieren - Körnerreihe sortieren
//12.10.2022, MF


void main() {
    sortieren(bubblesort(zählen(länge())));
}

void sortieren(int[] a)
{
	kehrt();
	for(int i = 0; i < a.length; i++)
	{
		while(kornDa())
		{
			nimm();
		}
		vor();
	}
	kehrt();
	for(int i = 0; i < a.length; i++)
	{
		for(int j = a[i]; j > 0; j--)
		{
			gib();
		} 
		vor();
	}
	schreib("Ich bin fertig mit sortieren");
}

int[] bubblesort(int[] a)
{
	int temp;
	for(int j = 0; j < a.length-1; j++)
	{
		for(int i = 0; i < a.length-1; i++)
		{
			if(a[i] > a[i+1])
			{
				temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
		}
	}
	return a;
}

int[] zählen(int x)
{
	int[] a = new int[x];
	for(int i = 0; i < x; i++)
	{
		vor();
		while(kornDa())
		{
			nimm();
			a[i]++;
		}
		for(int j = 0; j < a[i]; j++)
		{
			gib();
		}
	}
	return a;
}

int länge()
{
	int x = 0;
	while(vornFrei())
	{
	 	x++;
	 	vor();
	}
	kehrt();
	for(int i = x; i > 0; i--)
	{
		vor();
	}
	kehrt();
	return x;
}

void ausgabe(int[] a)
{
	for(int i : a)
	{
		schreib("" + i);
	}
}


void kehrt()
{
	linksUm();
	linksUm();
}

//implement the insertion sort algorithm


int[] shellsort(int[] a)
{
	int temp;
	for(int i = a.length/2; i > 0; i = i/2)
	{
		for(int j = i; j < a.length; j++)
		{
			temp = a[j];
			int k;
			for(k = j; k >= i && a[k - i] > temp; k -= i)
			{
				a[k] = a[k-i];
			}
			a[k] = temp;
		}
	}
	return a;
}