using System;
using System.Linq;
using System.Collections.Generic;

namespace SnakeEat
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> responses = new List<int>();
            int TestCaseCount = Int32.Parse(Console.ReadLine());
            for(int i = 0; i < TestCaseCount; i++)
            {
                List<int> query_parameters = Console.ReadLine().Split().Select(Int32.Parse).ToList<int>();
                int query_count = query_parameters[1];
                List<int> sneks = (Console.ReadLine().Split().Select(Int32.Parse)).ToList<int>();
                List<int> snek_store = new List<int>(sneks);
                for(int j = 0; j < query_count; j++)
                {
                    int valid_snakes = 0;
                    int min_length = int.Parse(Console.ReadLine());
                    sneks.Sort();
                    List<int> removal_index = new List<int>();
                    for(int n = 0; n < sneks.Count; n++)
                    {
                        if(sneks[n] >= min_length)
                        {
                            valid_snakes++;
                            removal_index.Add(n);
                        }
                    }
                    removal_index.Reverse();
                    foreach (int index in removal_index)
                    {
                        sneks.RemoveAt(index);
                    }
                    sneks.Reverse();
                    removal_index.Clear();
                    while (sneks.Count > 0)
                    {
                        int current_snake = sneks[0];
                        sneks.RemoveAt(0);
                        sneks.Reverse();
                        int z = 1;
                        foreach(int snake in sneks)
                        {
                            if (current_snake < min_length)
                            {
                                if(current_snake > snake)
                                {
                                    current_snake++;
                                    removal_index.Add((sneks.Count - z));
                                }
                            }
                            z++;
                        }
                        sneks.Reverse();
                        foreach (int index in removal_index)
                        {
                            sneks.RemoveAt(index);
                        }
                        removal_index.Clear();
                        if(current_snake >= min_length)
                        {
                            valid_snakes++;
                        }
                    }
                    responses.Add(valid_snakes);
                    sneks = snek_store;
                }
            }
            foreach (int snooooke in responses)
            {
                Console.WriteLine(snooooke);
            }
        }
    }
}
