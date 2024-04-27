3.3. Сбалансированные деревья поиска

 - Task 1: Plan - 1; Fact - 2.
 - Task 2: Plan - 0,7; Fact - 0,7.
 - Task 3: Plan -0,5; Fact - 0,5.
 - Task 4: Plan - 1; Fact - 0,6.

Условия заданий:

# Task 1:
3.3.31

_Вычерчивание дерева._ Добавьте в класс _RedBlackBST_ метод draw(), который вычерчивает красно-черные ДБП.


# Task 2 :
3.3.39

_Удаление наименьшего_. Реализуйте операцию _deleteMin()_ для красно-черных ДБП, поддерживая инвариант, что текущий узел не является 2-узлом. 

# Task 3 :
3.3.40

_Удаление наибольшего_. Реализуйте операцию _deleteMax()_ для красно-черных ДБП. Учтите, что необходимые для этого преобразования несколько отличаются от преобразований для _deleteMin()_, т.к. красные ссылки направлены влево.

# Task 4 :
3.3.42

_Подсчет красных узлов_. Напишите программу, которая вычисляет процент красных узлов в заданном красно-черном ДБП. Проверьте работу программы, выполнив, по крайней мере, 100 раз вставку N случайных ключей в первоначально пустое дерево, для N = $10^4$, $10^5$, $10^6$, и сформулируйте гипотезу.