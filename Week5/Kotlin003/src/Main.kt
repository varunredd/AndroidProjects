//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val node = Node(value = 1)
    val node1 = Node(value = 2)
    val node2 = Node(value = 3)
    node.next = node1
    node1.next = node2
    println(node)

    val  linkedList = LinkedList<Int>()
    linkedList.push(13).push(12).push(11).push(10)
    linkedList.append(14)
    println(linkedList)
    var nodeAtPos = linkedList.nodeAt(1);
    println(nodeAtPos)

    for(i in 1..3){
        linkedList.insertAt(-1*i,nodeAtPos)
    }
    println(linkedList)

    linkedList.createCircularDependency(2)
    println(linkedList.hasCycle())


}

