package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class OrdersGroup(clOrdIDField:Option[ClOrdIDField]=None,
                       orderIDField:Option[OrderIDField]=None,
                       secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                       secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                       listIDField:Option[ListIDField]=None,
                       nestedParties2Component:Option[NestedParties2Component]=None,
                       orderQtyField:Option[OrderQtyField]=None,
                       orderAvgPxField:Option[OrderAvgPxField]=None,
                       orderBookingQtyField:Option[OrderBookingQtyField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    clOrdIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    secondaryOrderIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    nestedParties2Component.foreach(fmt(b,_))
    orderQtyField.foreach(fmt(b,_))
    orderAvgPxField.foreach(fmt(b,_))
    orderBookingQtyField.foreach(fmt(b,_))
    b
  }

}
     
object OrdersGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedParties2Component.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, OrderIDField.TagId, SecondaryOrderIDField.TagId, SecondaryClOrdIDField.TagId, ListIDField.TagId, 
    OrderQtyField.TagId, OrderAvgPxField.TagId, OrderBookingQtyField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedParties2Component.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedParties2Component.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClOrdIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[OrdersGroup]=ArrayBuffer.empty[OrdersGroup]):Option[List[OrdersGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[OrdersGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[OrdersGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(OrdersGroup(myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
          myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
          myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
          myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
          myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
          NestedParties2Component.decode(flds, startPos),
          myFields.get(OrderQtyField.TagId).flatMap(f=>OrderQtyField.decode(f)),
          myFields.get(OrderAvgPxField.TagId).flatMap(f=>OrderAvgPxField.decode(f)),
          myFields.get(OrderBookingQtyField.TagId).flatMap(f=>OrderBookingQtyField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     