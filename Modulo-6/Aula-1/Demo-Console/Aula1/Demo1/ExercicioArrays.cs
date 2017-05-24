using System;

namespace Demo1
{
    class ExercicioArrays
    {
        private static int TAM_INICIAL = 1;
        private static int RESIZE_FACTOR = 1;
        public static void Main()
        {
            var array = new int[TAM_INICIAL];
            var index = 0;
            Console.WriteLine("Digite o valor");
            String input = Console.ReadLine();
            while (input != "exit")
            {                
                array = Resize(array, index);
                array[index++] = int.Parse(input);
                Console.WriteLine("Digite o valor");
                input = Console.ReadLine();
            }
            foreach (int i in array)
            {
                Console.WriteLine(i);
            }
            Console.ReadKey();
        }

        public static int[] Resize(int[] array, int index)
        {
            if (index == array.Length)
            {
                int[] aux = new int[array.Length + RESIZE_FACTOR];
                for (int i = 0; i < array.Length; i++)
                {
                    aux[i] = array[i];
                }
                return aux;
            }
            return array;
        }
    }
}
