package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class ListStatusMessage(listIDField:ListIDField,
                             listStatusTypeField:ListStatusTypeField,
                             noRptsField:NoRptsField,
                             listOrderStatusField:ListOrderStatusField,
                             rptSeqField:RptSeqField,
                             listStatusTextField:Option[ListStatusTextField]=None,
                             encodedListStatusTextLenField:Option[EncodedListStatusTextLenField]=None,
                             encodedListStatusTextField:Option[EncodedListStatusTextField]=None,
                             transactTimeField:Option[TransactTimeField]=None,
                             totNoOrdersField:TotNoOrdersField,
                             lastFragmentField:Option[LastFragmentField]=None,
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
    fmt(b,listStatusTypeField)
    fmt(b,noRptsField)
    fmt(b,listOrderStatusField)
    fmt(b,rptSeqField)
    listStatusTextField.foreach(fmt(b,_))
    encodedListStatusTextLenField.foreach(fmt(b,_))
    encodedListStatusTextField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    fmt(b,totNoOrdersField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,noOrdersField)
    b
  }

}
     
object ListStatusMessage extends SfFixMessageDecoder {
  val MsgType="N"
  val MsgName="ListStatus"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, ListStatusTypeField.TagId, NoRptsField.TagId, ListOrderStatusField.TagId, RptSeqField.TagId, 
    TotNoOrdersField.TagId, NoOrdersField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ListStatusTextField.TagId, EncodedListStatusTextLenField.TagId, EncodedListStatusTextField.TagId, TransactTimeField.TagId, LastFragmentField.TagId)

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
        ListStatusTypeField.decode(myFields.get(ListStatusTypeField.TagId)).get,
        NoRptsField.decode(myFields.get(NoRptsField.TagId)).get,
        ListOrderStatusField.decode(myFields.get(ListOrderStatusField.TagId)).get,
        RptSeqField.decode(myFields.get(RptSeqField.TagId)).get,
        myFields.get(ListStatusTextField.TagId).flatMap(f=>ListStatusTextField.decode(f)),
        myFields.get(EncodedListStatusTextLenField.TagId).flatMap(f=>EncodedListStatusTextLenField.decode(f)),
        myFields.get(EncodedListStatusTextField.TagId).flatMap(f=>EncodedListStatusTextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        TotNoOrdersField.decode(myFields.get(TotNoOrdersField.TagId)).get,
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        NoOrdersField.decode(myFields.get(NoOrdersField.TagId)).get,
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)).get else List.empty))
    } else None
  }

    
}
     