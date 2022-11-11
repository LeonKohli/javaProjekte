//Arrays sortieren - Körnerreihe sortieren
//12.10.2022, MF


void main() { 
    sortieren(SelectionSort(zählen(länge())));
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



int[] SelectionSort(int[] a)
{
	for(int i = 0; i < a.length - 1; i++)
	{
		int min = i;
		for(int j = i + 1; j < a.length; j++)
		{
			if(a[j] < a[min])
			{
				min = j;
			}
		}
		int temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}
	return a;
}