package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class ListStatusMessage(listIDField:ListIDField,
                             listStatusTypeField:ListStatusTypeField,
                             noRptsField:NoRptsField,
                             listOrderStatusField:ListOrderStatusField,
                             contingencyTypeField:Option[ContingencyTypeField]=None,
                             listRejectReasonField:Option[ListRejectReasonField]=None,
                             rptSeqField:RptSeqField,
                             listStatusTextField:Option[ListStatusTextField]=None,
                             encodedListStatusTextLenField:Option[EncodedListStatusTextLenField]=None,
                             encodedListStatusTextField:Option[EncodedListStatusTextField]=None,
                             transactTimeField:Option[TransactTimeField]=None,
                             totNoOrdersField:TotNoOrdersField,
                             lastFragmentField:Option[LastFragmentField]=None,
                             ordListStatGrpComponent:OrdListStatGrpComponent) extends SfFixMessageBody("N")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    fmt(b,listStatusTypeField)
    fmt(b,noRptsField)
    fmt(b,listOrderStatusField)
    contingencyTypeField.foreach(fmt(b,_))
    listRejectReasonField.foreach(fmt(b,_))
    fmt(b,rptSeqField)
    listStatusTextField.foreach(fmt(b,_))
    encodedListStatusTextLenField.foreach(fmt(b,_))
    encodedListStatusTextField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    fmt(b,totNoOrdersField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,ordListStatGrpComponent)
    b
  }

}
     
object ListStatusMessage extends SfFixMessageDecoder {
  val MsgType="N"
  val MsgName="ListStatus"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, ListStatusTypeField.TagId, NoRptsField.TagId, ListOrderStatusField.TagId, RptSeqField.TagId, 
    TotNoOrdersField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdListStatGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ContingencyTypeField.TagId, ListRejectReasonField.TagId, ListStatusTextField.TagId, EncodedListStatusTextLenField.TagId, EncodedListStatusTextField.TagId, 
    TransactTimeField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdListStatGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdListStatGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ListStatusMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        ListStatusTypeField.decode(myFields.get(ListStatusTypeField.TagId)).get,
        NoRptsField.decode(myFields.get(NoRptsField.TagId)).get,
        ListOrderStatusField.decode(myFields.get(ListOrderStatusField.TagId)).get,
        myFields.get(ContingencyTypeField.TagId).flatMap(f=>ContingencyTypeField.decode(f)),
        myFields.get(ListRejectReasonField.TagId).flatMap(f=>ListRejectReasonField.decode(f)),
        RptSeqField.decode(myFields.get(RptSeqField.TagId)).get,
        myFields.get(ListStatusTextField.TagId).flatMap(f=>ListStatusTextField.decode(f)),
        myFields.get(EncodedListStatusTextLenField.TagId).flatMap(f=>EncodedListStatusTextLenField.decode(f)),
        myFields.get(EncodedListStatusTextField.TagId).flatMap(f=>EncodedListStatusTextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        TotNoOrdersField.decode(myFields.get(TotNoOrdersField.TagId)).get,
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        OrdListStatGrpComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     