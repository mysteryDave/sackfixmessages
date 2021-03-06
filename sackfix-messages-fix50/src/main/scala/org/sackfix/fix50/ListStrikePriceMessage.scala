package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class ListStrikePriceMessage(listIDField:ListIDField,
                                  totNoStrikesField:TotNoStrikesField,
                                  lastFragmentField:Option[LastFragmentField]=None,
                                  instrmtStrkPxGrpComponent:InstrmtStrkPxGrpComponent,
                                  undInstrmtStrkPxGrpComponent:Option[UndInstrmtStrkPxGrpComponent]=None) extends SfFixMessageBody("m")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    fmt(b,totNoStrikesField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,instrmtStrkPxGrpComponent)
    undInstrmtStrkPxGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object ListStrikePriceMessage extends SfFixMessageDecoder {
  val MsgType="m"
  val MsgName="ListStrikePrice"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, TotNoStrikesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrmtStrkPxGrpComponent.isMandatoryField(tagId) || UndInstrmtStrkPxGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrmtStrkPxGrpComponent.isOptionalField(tagId) || UndInstrmtStrkPxGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrmtStrkPxGrpComponent.isFieldOf(tagId) || UndInstrmtStrkPxGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ListStrikePriceMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        TotNoStrikesField.decode(myFields.get(TotNoStrikesField.TagId)).get,
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        InstrmtStrkPxGrpComponent.decode(flds, startPos).get,
        UndInstrmtStrkPxGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     