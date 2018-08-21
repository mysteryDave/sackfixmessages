package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class ListStatusMessage(listIDField:ListIDField,
                             waveNoField:Option[WaveNoField]=None,
                             noRptsField:NoRptsField,
                             rptSeqField:RptSeqField,
                             noOrdersField:NoOrdersField,
                             ordersGroups: List[OrdersGroup]) extends SfFixMessageBody("N")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdersField.value != ordersGroups.size)
    throw SfRepeatingGroupCountException(NoOrdersField.TagId,noOrdersField.value, ordersGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    waveNoField.foreach(fmt(b,_))
    fmt(b,noRptsField)
    fmt(b,rptSeqField)
    fmt(b,noOrdersField)
    b
  }

}
     
object ListStatusMessage extends SfFixMessageDecoder {
  val MsgType="N"
  val MsgName="ListStatus"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, NoRptsField.TagId, RptSeqField.TagId, NoOrdersField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    WaveNoField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ListStatusMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        myFields.get(WaveNoField.TagId).flatMap(f=>WaveNoField.decode(f)),
        NoRptsField.decode(myFields.get(NoRptsField.TagId)).get,
        RptSeqField.decode(myFields.get(RptSeqField.TagId)).get,
        NoOrdersField.decode(myFields.get(NoOrdersField.TagId)).get,
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)).get else List.empty))
    } else None
  }

    
}
     