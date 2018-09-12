package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class OrdersGroup(clOrdIDField:ClOrdIDField,
                       cumQtyIntField:CumQtyIntField,
                       leavesQtyIntField:LeavesQtyIntField,
                       cxlQtyIntField:CxlQtyIntField,
                       avgPxField:AvgPxField) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,clOrdIDField)
    fmt(b,cumQtyIntField)
    fmt(b,leavesQtyIntField)
    fmt(b,cxlQtyIntField)
    fmt(b,avgPxField)
    b
  }

}
     
object OrdersGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, CumQtyIntField.TagId, LeavesQtyIntField.TagId, CxlQtyIntField.TagId, AvgPxField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

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
        (pos,Some(OrdersGroup(ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
          CumQtyIntField.decode(myFields.get(CumQtyIntField.TagId)).get,
          LeavesQtyIntField.decode(myFields.get(LeavesQtyIntField.TagId)).get,
          CxlQtyIntField.decode(myFields.get(CxlQtyIntField.TagId)).get,
          AvgPxField.decode(myFields.get(AvgPxField.TagId)).get)))
      } else (startPos, None)
    }
  }
    
}
     